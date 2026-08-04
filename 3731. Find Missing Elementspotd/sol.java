class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        List<Integer>l=new ArrayList<>();
        Set<Integer>set=new HashSet<>();

        for(int i:nums){
            set.add(i);
        }
        for(int i=min;i<max;i++){
            if(!set.contains(i)){
                l.add(i);
            }
        }
        return l;
    }
}
