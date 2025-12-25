class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        reverse(nums,n);

        long res=0;
        for(int i=0;i<k;i++){
            res+=(nums[i]-i)>0?nums[i]-i:0;
        }
        return res;
    }
    public void reverse(int[] nums,int n){
        for(int i=0;i<n/2;i++){
            int temp=nums[i];
            nums[i]=nums[n-i-1];
            nums[n-1-i]=temp;
        }
    }
}
