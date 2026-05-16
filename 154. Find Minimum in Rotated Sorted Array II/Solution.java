class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        int ans=Integer.MAX_VALUE;

        int l=0;
        int r=n-1;

        while(l<=r){

            while(l<r && nums[l]==nums[l+1])l++;
            while(r>l && nums[r]==nums[r-1])r--;

            int mid=l+(r-l)/2;
            
            ans=Math.min(ans,nums[mid]);
            if(nums[mid]>nums[r]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}
