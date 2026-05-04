class Solution {

    int[] dp;

    public int numSquares(int n) {

        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n);
    }
    public int dfs(int n){
        
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int res=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){

            int candidate=i*i;
            res=Math.min(res,1+dfs(n-candidate));
        }
        return dp[n]=res;
    }
}
