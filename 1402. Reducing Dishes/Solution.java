class Solution {

    int n;
    int[][] dp;

    public int maxSatisfaction(int[] happy) {
        Arrays.sort(happy);
        n=happy.length;

        dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(happy,0,1);
    }
    public int solve(int[] a,int idx,int fact){
        if(idx>=n)return 0;

        if(dp[idx][fact]!=-1)return dp[idx][fact];

        int pick=a[idx]*fact+solve(a,idx+1,fact+1);
        int skip=solve(a,idx+1,fact);

        return dp[idx][fact]=Math.max(pick,skip);
    }
}
