class Solution {

    int[] segTree;

    void intialize(int n){
        segTree=new int[4*n];
    }
    public void update(int index,int l,int r,int position,int value){

        if(l==r){
            segTree[index]+=value;
            return;
        }
        int mid=l+(r-l)/2;

        if(position<=mid){
            update(index*2+1,l,mid,position,value);
        }
        else{
            update(index*2+2,mid+1,r,position,value);
        }
        segTree[index]=segTree[index*2+1]+segTree[index*2+2];
    }
    public long query(int idx,int l,int r,int qL,int qR){

        if(qL<=l && qR>=r){
            return segTree[idx];
        }
        if(qL>r || qR<l){
            return 0;
        }
        int mid=l+(r-l)/2;

        long onLeft=query(idx*2+1,l,mid,qL,qR);
        long onRight=query(idx*2+2,mid+1,r,qL,qR);

        return onLeft+onRight;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        
        int n=nums.length;
        int total=2*n+1;

        int offset=n;

        intialize(2*n+1);

        update(0,0,total,offset,1);

        int cummSum=0;

        long res=0;

        for(int i=0;i<n;i++){

            if(nums[i]==target){
                cummSum++;
            }
            else{
                cummSum--;
            }

            int searchIdx=cummSum+offset-1;

            if(searchIdx>=0){
                res+=query(0,0,total,0,searchIdx);
            }
            update(0,0,total,cummSum+offset,1);
        }
        return res;
    }
}
