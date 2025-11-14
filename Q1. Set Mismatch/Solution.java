class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res=new int[2];
        int n=nums.length,idx=0;

        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i))res[idx++]=i;
            else set.add(i);
        }

        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                res[idx++]=i;
            }
        }
        return res;
    }
}
