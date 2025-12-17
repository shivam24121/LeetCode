class Solution {

    int n;
    long[][][] dp;
    static long neg=-(long)1e18;
    static long assign=Long.MIN_VALUE;

    public long maximumProfit(int[] prices, int k){
        n=prices.length;
        dp=new long[n+1][k+1][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],assign);
            }
        }
        return solve(0,prices,0,k);
    }
    public long solve(int idx,int[] a,int state,int k){
        if(idx>=n){
            if(state==0){
                return 0;
            }
            else return neg;
        }
        if(k==0 && state!=0)return neg;
        if(dp[idx][k][state]!=assign)return dp[idx][k][state];

        long take=neg;
        long skip=solve(idx+1,a,state,k);

        if(k>0){
            if(state==1){
                take=a[idx]+solve(idx+1,a,0,k-1);
            }
            else if(state==2){
                take=-a[idx]+solve(idx+1,a,0,k-1);
            }
            else{
                long buy=-a[idx]+solve(idx+1,a,1,k);
                long sell=a[idx]+solve(idx+1,a,2,k);
                take=Math.max(buy,sell);
            }
        }
        return dp[idx][k][state]=Math.max(take,skip);
    }
}
