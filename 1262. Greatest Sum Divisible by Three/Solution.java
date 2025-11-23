class Solution {

    Integer[][] dp;

    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][3];
        return solve(0,nums,0);
    }
    public int solve(int idx,int[] nums,int rem){
        if(idx==nums.length){
            return rem==0?0:Integer.MIN_VALUE;
        }
        if(dp[idx][rem]!=null)return dp[idx][rem];

        int skip=solve(idx+1,nums,rem);
        int take=0;
        int next=(nums[idx]+rem)%3;
        take=nums[idx]+solve(idx+1,nums,next);

        return dp[idx][rem]=Math.max(take,skip);
    }
}
