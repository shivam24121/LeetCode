class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        long sum=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
            sum+=nums[i];
        }
        int res=0;
        for(int i=0;i<n-1;i++){
            int currSum=prefix[i];
            int rem=prefix[n-1]-prefix[i];
            if(Math.abs(rem-currSum)%2==0){
                res++;
            }
        }
        return res;
    }
}
