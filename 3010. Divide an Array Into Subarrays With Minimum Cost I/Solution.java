class Solution {
    public int minimumCost(int[] nums) {
        int ans=nums[0];
        int n=nums.length;

        int min=Integer.MAX_VALUE;
        int secMin=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            if(nums[i]<min){
                secMin=min;
                min=nums[i];
            }
            else if(nums[i]<secMin){
                secMin=nums[i];
            }
        }
        return ans+min+secMin;
    }
}
