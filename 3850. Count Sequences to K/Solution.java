class Solution {
    Map<String,Integer>map=new HashMap<>();
    public int countSequences(int[] nums, long k) {
        return solve(0,1.0,nums,k);
    }
    public int solve(int idx,double val,int[] nums,long k){
        if(idx==nums.length){
            return Math.abs(val-k)<1e-9?1:0;
        }
        String key=idx+"_"+val;

        if(map.containsKey(key))return map.get(key);
        
        int mul=solve(idx+1,val*nums[idx],nums,k);
        int div=solve(idx+1,val/(double)nums[idx],nums,k);
        int skip=solve(idx+1,val,nums,k);

        map.put(key,mul+div+skip);

        return mul+div+skip;
    }
}
