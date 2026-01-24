class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Long,Integer>map=new HashMap<>();
        map.put(0l,-1);
        long x=0;
        for(int i=0;i<nums.length;i++){
            x=(x+nums[i])%k;
            if(map.containsKey(x) && i-map.get(x)>=2){
                return true;
            }
            if(!map.containsKey(x)){
                map.put(x,i);
            }
        }
        return false;
    }
}
