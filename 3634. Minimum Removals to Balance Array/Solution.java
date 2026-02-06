class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int len=0;
        int l=0;

        for(int i=0;i<n;i++){
            while(nums[l]*(long)k<nums[i]){
                l++;
            }
            len=Math.max(len,i-l+1);
        }
        return n-len;
    }
}
