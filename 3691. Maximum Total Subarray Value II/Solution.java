class Solution {

    int[] minSeg;
    int[] maxSeg;
    int n;

    void segTree(int[] nums){

        minSeg=new int[n*4];
        maxSeg=new int[n*4];

        build(0,0,n-1,nums);
    }
    public void build(int idx,int l,int r,int[] nums){

        if(l==r){
            minSeg[idx]=nums[l];
            maxSeg[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;

        build(idx*2+1,l,mid,nums);
        build(idx*2+2,mid+1,r,nums);

        minSeg[idx]=Math.min(minSeg[idx*2+1],minSeg[idx*2+2]);
        maxSeg[idx]=Math.max(maxSeg[idx*2+1],maxSeg[idx*2+2]);
    }
    public int query(int idx,int l,int r,int queryL,int queryR,int type){

        // System.out.println(l+" "+r);

        if(r<queryL || l>queryR){
            return type==0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(queryL<=l && queryR>=r){
            return type==0?minSeg[idx]:maxSeg[idx];
        }
        else{
            int mid=l+(r-l)/2;

            int leftSide=query(idx*2+1,l,mid,queryL,queryR,type);
            int rightSide=query(idx*2+2,mid+1,r,queryL,queryR,type);

            return type==0?Math.min(leftSide,rightSide):Math.max(leftSide,rightSide);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        
        n=nums.length;

        segTree(nums);

        long res=0;

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++){
            int diff=query(0,0,n-1,i,n-1,1)-query(0,0,n-1,i,n-1,0);
            int l=i;
            int r=n-1;
            pq.offer(new int[]{diff,l,r});
        }

        while(!pq.isEmpty() && k>0){

            int[] curr=pq.poll();
            res+=curr[0];
            int l=curr[1];
            int r=curr[2];
            
            // System.out.println(curr[0]+ " "+ curr[1]+" "+curr[2]);
            k--;

            if(l<r){
    
                int diff=query(0,0,n-1,l,r-1,1)-query(0,0,n-1,l,r-1,0);
                pq.offer(new int[]{diff,l,r-1});
            }
        }
        return res;
    }
}
