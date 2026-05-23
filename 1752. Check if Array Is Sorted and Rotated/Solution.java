class Solution {
    public boolean check(int[] nums) {
        
        int ct=0;
        int n=nums.length;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                ct++;
            }
        }
        if(nums[0]<nums[n-1]){
            ct++;
        }
        return ct<=1;
    }
}
