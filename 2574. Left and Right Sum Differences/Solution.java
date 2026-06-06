class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int total=0;
        for(int i:nums){
            total+=i;
        }
        
        int n=nums.length;
        int[] res=new int[n];
        int sum=0;

        for(int i=0;i<n;i++){
            res[i]=Math.abs(sum-(total-sum-nums[i]));
            sum+=nums[i];
        }
        return res;
    }
}
