class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0,res=nums.length+1;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return res==nums.length+1?0:res;
    }
}
