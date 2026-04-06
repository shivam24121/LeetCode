class Solution {

    int n;
    int[][] dp;

    public int maxProfit(int[] prices, int fee) {
        
        n=prices.length;

        dp=new int[n][2];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }

        return solve(0,0,prices,fee);
    }
    public int solve(int idx,int state,int[] price,int k){

        if(idx==n)return 0;

        if(dp[idx][state]!=-1){
            return dp[idx][state];
        }

        int pick=Integer.MIN_VALUE;
        int skip=Integer.MIN_VALUE;

        if(state==0){

            pick=Math.max(pick,-price[idx]+solve(idx+1,1,price,k));
            skip=Math.max(skip,solve(idx+1,0,price,k));
        }
        else{

            pick=Math.max(pick,price[idx]-k+solve(idx+1,0,price,k));
            skip=Math.max(skip,solve(idx+1,1,price,k));
        }
        return dp[idx][state]=Math.max(pick,skip);
    }
}
