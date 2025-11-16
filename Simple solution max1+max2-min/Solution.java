class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n=nums.length;
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i:nums){
            if(i>max1){
                max2=max1;
                max1=i;
            }
            else if(i>max2){
                max2=i;
            }
            min=Math.min(i,min);
        }
        return max1+max2-min;
    }
}
