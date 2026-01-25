class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n=nums.length;
        int idx=0;

        int i=n-1;
        while(i>=1 && nums[i]>nums[i-1]){
            i--;
        }
        return i;
    }
}
