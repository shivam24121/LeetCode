class Solution {
    public int minSwap(int[] nums1, int[] nums2) {

        int[] prev={0,1};

        for(int i=1;i<nums1.length;i++){

            int[] curr={Integer.MAX_VALUE,Integer.MAX_VALUE};

            if(nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
                curr[0]=prev[0];
                curr[1]=prev[1]+1;
            }
            if(nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1]){
                curr[0]=Math.min(curr[0],prev[1]);
                curr[1]=Math.min(curr[1],prev[0]+1);
            }
            prev[0]=curr[0];
            prev[1]=curr[1];
        }
        return Math.min(prev[0],prev[1]);
    }
}
