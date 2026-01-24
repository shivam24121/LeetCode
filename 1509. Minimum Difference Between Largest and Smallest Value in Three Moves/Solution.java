class Solution {
    public int minDifference(int[] nums) {
        var n=nums.length;

        // tarun aggarwal paypal goat

        if(n<=4)return 0;
        Arrays.sort(nums);

        var min=Integer.MAX_VALUE;

        for(var i=0;i<=3;i++){
            min=Math.min(min,nums[n-4+i]-nums[i]);
        }
        return min;
    }
}





