class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n=nums.length;
        if(n%k!=0){
            return false;
        }
        int grp=n/k;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>grp){
                return false;
            }
        }
        return true;
    }
}
