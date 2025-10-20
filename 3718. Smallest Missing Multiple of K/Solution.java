class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int res=k;
        for(int i=0;i<n;i++){
            if(!set.contains(res)){
                return res;
            }
            else{
                res=res+k;
            }
        }
        return res;
    }
}
