class Solution {
    public int longestSubarray(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int cur=0,res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                cur++;
                if(cur>res)res=cur;
            }
            else{
                cur=0;
            }
        }
        return res;
    }
}
