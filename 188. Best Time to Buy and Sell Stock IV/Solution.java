class Solution {

    int[][][] dp;
    int n;

    public int maxProfit(int k, int[] prices) {
        
        n=prices.length;

        dp=new int[n+1][2][k+1];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }

        return solve(0,0,k,prices);
    }

    public int solve(int idx,int state,int k,int[] arr){

        if(idx==n || k==0){
            return 0;
        }

        if(dp[idx][state][k]!=-1){
            return dp[idx][state][k];
        }

        int take=Integer.MIN_VALUE;
        int skip=Integer.MIN_VALUE;

        if(state==0){
            take=Math.max(take,-arr[idx]+solve(idx+1,1,k,arr));
            skip=Math.max(skip,solve(idx+1,0,k,arr));
        }
        else{
            take=Math.max(take,arr[idx]+solve(idx+1,0,k-1,arr));
            skip=Math.max(skip,solve(idx+1,1,k,arr));
        }
        return dp[idx][state][k]=Math.max(take,skip);
    }
}
