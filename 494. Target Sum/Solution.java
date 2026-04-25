class Solution {

    int n;
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        
        n=nums.length;
        dp=new int[n+1][2002];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }

        return solve(0,nums,target);
    }
    public int solve(int idx,int[] nums,int k){
        // System.out.println(idx+" "+k);
        if(idx==n){
            return k==0?1:0;
        }
        if(k<-1000 || k>1000){
            return 0;
        }
        if(dp[idx][k+1001]!=-1){
            return dp[idx][k+1001];
        }
        return dp[idx][k+1001]=solve(idx+1,nums,k+nums[idx])+solve(idx+1,nums,k-nums[idx]);
    }
}
