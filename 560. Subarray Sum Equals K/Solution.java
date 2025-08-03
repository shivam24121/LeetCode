class Solution {
    public int subarraySum(int[] nums, int k) {
       int n=nums.length;
       Map<Integer,Integer> hm=new HashMap<>();
       int ct=0;
       int cursum=0;
       hm.put(0,1);
       for(int i=0;i<n;i++){
        cursum+=nums[i];
        if(hm.containsKey(cursum-k)){
            ct+=hm.get(cursum-k);
        }
        hm.put(cursum-k,hm.getOrDefault(cursum,0)+1);
       } 
       return ct;
    }
}
