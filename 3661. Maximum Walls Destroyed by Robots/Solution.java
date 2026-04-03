class Solution {

    int n;
    int[][] dp;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        
        n=robots.length;

        dp=new int[n+1][2];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }

        // make a 2d array to sort the robo and it effective distacne;

        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=robots[i];
            arr[i][1]=distance[i];
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        Arrays.sort(walls);

        int[][] range=new int[n][2];

        // store the l and r of robots , l=max, r=min;

        for(int i=0;i<n;i++){

            int curr=arr[i][0];
            int dist=arr[i][1];

            int left=i==0?0:arr[i-1][0]+1;
            int right=i==n-1?Integer.MAX_VALUE:arr[i+1][0]-1;

            // consider the effective range as prev+1 and next-1

            int l=Math.max(curr-dist,left);
            int r=Math.min(curr+dist,right);

            range[i][0]=l;
            range[i][1]=r;
        }

        return solve(0,0,arr,walls,range);
    }

    /* 

       dir is the the direction where prev robot went , so agar it goes towards the
       left , then if would not affect the abhi wala but if it went right then we have to ensure the
       effective range become prev ka range[1](right)+1

    */
    
    public int solve(int idx,int dir,int[][] arr,int[] walls,int[][] range){

        if(idx==n){
            return 0;
        }

        if(dp[idx][dir]!=-1){
            return dp[idx][dir];
        }

        // left = 0 and right= 1 (direction ofc :)
        
        int l=range[idx][0];
        int r=range[idx][1];

        if(dir==1){

            l=Math.max(l,range[idx-1][1]+1);

        }

        int lAns=shoot(walls,l,arr[idx][0])+solve(idx+1,0,arr,walls,range);

        int rAns=shoot(walls,arr[idx][0],r)+solve(idx+1,1,arr,walls,range);

        return dp[idx][dir]=Math.max(lAns,rAns);
    }

    public int shoot(int[] walls,int l,int r){

        int lAns=lowerbound(walls,l);
        int rAns=upperbound(walls,r);

        int currShoot=rAns-lAns;

        return currShoot;
    }

    public int lowerbound(int[] arr,int x){
        
        int ans=arr.length;

        int l=0,r=arr.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=x){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int upperbound(int[] arr,int x){

        int l=0,r=arr.length-1;
        int ans=arr.length;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>x){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
