class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int res=nums[0],temp;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                temp=max;
                max=min;
                min=temp;
            } 
        max=Math.max(nums[i],nums[i]*max);
        min=Math.min(nums[i],nums[i]*min);
        res=Math.max(res,max);
        }
        return res;
    }
}
