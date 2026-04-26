class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer>set=new HashSet<>();

        for(int i:nums){
            set.add(i);
        }
        int res=0;
   
        for(int i:set){
  
            if(!set.contains(i-1)){

                int ct=1;
                int val=i;

                while(set.contains(val+1)){
                    val++;
                    ct++;
                }
                res=Math.max(res,ct);
            }

        }
        
        return res;
    }
}
