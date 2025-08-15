class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private static void reverse(int[] nums,int st,int ed){
        while(st<ed){
            int temp=nums[st];
            nums[st]=nums[ed];
            nums[ed]=temp;
            st++;
            ed--;
        }
    }
}
