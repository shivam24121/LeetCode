class Solution {
    public int triangleNumber(int[] nums) {
        int ct=0;
        int n=nums.length;
        for(int i=n-1;i>=2;i--){
            int l=0;
            int r=i-1;

            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    ct+=r-l;
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return ct;
    }
}
