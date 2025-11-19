class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n=nums.length;
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(!set.contains(original))return original;
        else{
            while(set.contains(original)){
                original=original*2;
            }
        }
        return original;
    }
}
