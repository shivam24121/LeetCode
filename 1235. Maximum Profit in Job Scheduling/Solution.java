class Solution {

    int n;
    int[] t;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n=profit.length;
        int[][] a=new int[n][3];
        t=new int[n+1];

        for(int i=0;i<n;i++){
            a[i][0]=startTime[i];
            a[i][1]=endTime[i];
            a[i][2]=profit[i];
        }
        Arrays.fill(t,-1);
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        return solve(a,0);
    }
    public int solve(int[][] a,int idx){
        if(idx>=n)return 0;

        if(t[idx]!=-1)return t[idx];

        int next=bs(a,idx+1,a[idx][1]);
        int take=a[idx][2]+solve(a,next);
        int skip=solve(a,idx+1);

        return t[idx]=Math.max(take,skip);
    }
    public int bs(int[][] a,int l,int target){
        int r=n-1;
        int res=n+1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid][0]>=target){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
}
