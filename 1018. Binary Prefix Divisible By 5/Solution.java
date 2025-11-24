class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean>res=new ArrayList<>();
        int mod=0;
        for(int i:nums){
            mod=(mod*2+i)%5;
            res.add(mod%5==0);
        }
        return res;
    }
}
