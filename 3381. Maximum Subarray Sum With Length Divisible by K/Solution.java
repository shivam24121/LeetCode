class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] prefix=new long[k];
        long inf=Long.MAX_VALUE;

        for(int i=0;i<k;i++){
            prefix[i]=inf;
        }
        prefix[0]=0;

        long p=0;
        long ans=Long.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            p+=nums[i];
            int mod=(i+1)%k;

            if(prefix[mod]!=inf){
                ans=Math.max(ans,p-prefix[mod]);
            }
            prefix[mod]=Math.min(prefix[mod],p);
        }
        return ans;
    }
}
