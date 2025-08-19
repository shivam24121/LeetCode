class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ct=0,res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ct++;
            }
            else{
                ct=0;
            }
            res+=ct;
        }
        return res;
    }
}
