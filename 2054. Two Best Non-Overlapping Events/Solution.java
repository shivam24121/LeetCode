class Solution {

    int[][] dp;
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        dp=new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(events,0,0);
    }
    public int solve(int[][] event,int idx,int ct){
        if(idx>=event.length || ct>=2)return 0;

        if(dp[idx][ct]!=-1)return dp[idx][ct];

        int skip=solve(event,idx+1,ct);
        int next=helper(event,idx);

        int pick=event[idx][2]+solve(event,next,ct+1);

        return dp[idx][ct]=Math.max(skip,pick);
    }
    public int helper(int[][] event,int idx){
        int l=idx+1,r=event.length-1;
        int res=event.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(event[mid][0]>event[idx][1]){
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
