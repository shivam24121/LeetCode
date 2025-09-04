class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int cpl=target-nums[i];
            if(map.containsKey(cpl)){
                return new int[]{map.get(cpl),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
