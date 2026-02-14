class Solution {
    public long rob(int[] nums, int[] colors) {

        int n=nums.length;
        long[] dp=new long[n];

        if(n==1)return nums[0];
        
        dp[0]=nums[0];
        dp[1]=colors[0]==colors[1]?Math.max(nums[0],nums[1]):nums[0]+nums[1];

        for(int i=2;i<n;i++){

            long take;

            if(colors[i]==colors[i-1]){
                take=nums[i]+dp[i-2];
            }
            else{
                take=nums[i]+dp[i-1];
            }
            dp[i]=Math.max(take,dp[i-1]);
        }
        return dp[n-1];
    }
}
