class Solution {
    public boolean asteroidsDestroyed(int sum, int[] nums) {
        
        int n=nums.length;
        Arrays.sort(nums);
        
        int max=0;
        
        for(int i:nums){
            max=Math.max(i,max);
        }

        for(int i=0;i<n;i++){
            if(sum<nums[i]){
                return false;
            }
            sum+=nums[i];
            if(sum>=max)return true;
        }
        return true;
    }
}
