class Solution {

    int[][] dp;

    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1)return 0;

        dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,prices,0);
    }
    public int solve(int idx,int[] a,int fl){
        if(idx>=a.length)return 0;

        if(dp[idx][fl]!=-1)return dp[idx][fl];

        if(fl==1){
            int op2=a[idx]+solve(idx+2,a,0);
            int op3=solve(idx+1,a,1);
            return dp[idx][fl]=Math.max(op2,op3);
        }
        else{
            int op1=-a[idx]+solve(idx+1,a,1);
            int op3=solve(idx+1,a,0);
            return dp[idx][fl]=Math.max(op1,op3);
        }
    }
}
