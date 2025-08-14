import java.util.stream.*;
class Solution {
    public int maxProductDifference(int[] nums) {
        //int max=Arrays.stream(nums).max().getAsInt();
        //int secMax=Arrays.stream(nums).filter(x->x!=max).max().orElse(max);
        //int min=Arrays.stream(nums).min().getAsInt();
        //int secMin=Arrays.stream(nums).filter(x->x!=min).min().orElse(min);
        int Max=Integer.MIN_VALUE,Min=Integer.MAX_VALUE;
        int secMax=Integer.MIN_VALUE,secMin=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>Max){
                secMax=Max;
                Max=nums[i];
            }
            else if(nums[i]>=secMax){
                secMax=nums[i];
            }
            if(nums[i]<Min){
                secMin=Min;
                Min=nums[i];
            }
            else if(nums[i]<=secMin){
                secMin=nums[i];
            }
        }
        return (Max*secMax)-(Min*secMin);
    }
}
