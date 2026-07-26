class Solution {
    public int maximumProduct(int[] nums) {
        
        int n=nums.length;

        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;

        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int min3=Integer.MAX_VALUE;

        for(int i:nums){

            if(i>max1){
                max3=max2;
                max2=max1;
                max1=i;
            }
            else if(i>=max2){
                max3=max2;
                max2=i;
            }
            else if(i>max3){
                max3=i;
            }

            if(i<min1){
                min3=min2;
                min2=min1;
                min1=i;
            }
            else if(i<min2){
                min3=min2;
                min2=i;
            }
            else if(i<min3){
                min3=i;
            }
        }
        long way1=max1*max2*max3;
        long way2=max1*max2*min1;
        long way3=max1*min1*min2;
        long way4=min1*min2*min3;

        long ans=Math.max(Math.max(way1,way2),Math.max(way3,way4));

        return (int)ans;
    }
}
