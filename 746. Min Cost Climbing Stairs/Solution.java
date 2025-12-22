class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost,0),solve(1,cost,0));
    }
    public int solve(int idx,int[] cost,int sum){
        if(idx>=cost.length)return 0;

        if(dp[idx]!=-1)return dp[idx];

        int one=solve(idx+1,cost,sum);
        int two=solve(idx+2,cost,sum);

        return dp[idx]=Math.min(one,two)+cost[idx];
    }
}
