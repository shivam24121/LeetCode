class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0,zero=0;
        int res=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zero++;
            }
            while(zero>1){
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            // window size is right-left+1 but in this case we have to remove one elment 
            //cumpulsory so -1 and +1 cancel and we get right-left;
            res=Math.max(res,right-left);
        }
        return res;
    }
}
