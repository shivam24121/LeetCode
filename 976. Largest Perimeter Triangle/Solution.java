class Solution {
    public int largestPerimeter(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        for(int i=2;i<n;i++){
            int l=0;
            int r=i-1;
            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    int temp=nums[l]+nums[r]+nums[i];
                    res=Math.max(res,temp);
                }
                l++;
            }
        }
        return res;
    }
}
