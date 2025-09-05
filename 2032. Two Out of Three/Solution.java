class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> res=new HashSet<>();
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            s1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(s1.contains(nums2[i])){
                res.add(nums2[i]);
            }
            s2.add(nums2[i]);
        }

        for(int i=0;i<nums3.length;i++){
            if(s1.contains(nums3[i]) || s2.contains(nums3[i])){
                res.add(nums3[i]);
            }
        }
        List <Integer> l=new ArrayList<>();
        for(int i:res){
            l.add(i);
        }
        return l;
    }
}
