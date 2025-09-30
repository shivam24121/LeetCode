class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int res=0;
        int max=0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        res=max;
        for(int i=k;i<n;i++){
            max+=nums[i]-nums[i-k];
            res=Math.max(res,max);
        }
        return res/(double)k;
    }
}
