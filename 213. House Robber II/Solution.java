class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        if(n==0)return 0;
        if(n==1)return nums[0];
        int res1=0;
        int res2=0;

        dp[0]=0;
        for(int i=1;i<=n-1;i++){
            int skip=dp[i-1];
            int pick=nums[i-1]+(((i-2)>=0)?dp[i-2]:0);
            dp[i]=Math.max(pick,skip);
        }
        res1=dp[n-1];

        dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int skip=dp[i-1];
            int pick=nums[i-1]+(((i-2)>=0)?dp[i-2]:0);
            dp[i]=Math.max(pick,skip);
        }
        res2=dp[n];
        return Math.max(res1,res2);
    }
}
