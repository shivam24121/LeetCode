class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/3 && !res.contains(nums[i])){
                res.add(nums[i]);
            }
        }
        return res;
    }
}
