class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ct=0,max=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==1)ct++;
            else ct=0;

            max=Math.max(max,ct);
        }
        return max;
    }
}
