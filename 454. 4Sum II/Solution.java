class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer>map=new HashMap<>();

        for(int i:nums1){
            for(int j:nums2){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        int ct=0;

        for(int i:nums3){
            for(int j:nums4){
                int cpl=-(i+j);
                ct+=map.getOrDefault(cpl,0);
            }
        }
        return ct;
    }
}
