class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
            if(nums[i]>max){
                secMax=max;
                max=nums[i];
            }
            else if(nums[i]>secMax){
                secMax=nums[i];
            }
        }
        return (long)1e5*max*secMax;
    }
}
