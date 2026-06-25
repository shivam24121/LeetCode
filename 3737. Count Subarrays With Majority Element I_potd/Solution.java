class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int res=0;

        for(int i=0;i<n;i++){

            int ct=0;
            int rest=0;

            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    ct++;
                }
                else{
                    rest++;
                }
                if(ct>rest){
                res++;
                }
            }
        }
        return res;
    }
}
