class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n=nums.length;
        int ct=0;
        int prev=Integer.MIN_VALUE;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            int min=nums[i]-k;

            if(prev<min){
                prev=min;
                ct++;
            }
            else if(prev<nums[i]+k){
                prev=prev+1;
                ct++;
            }
        }
        return ct;
    }
}
