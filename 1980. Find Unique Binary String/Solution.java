class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int n=nums.length;
        int total=1<<n;
        String ans="";

        HashSet<String>set=new HashSet<>(Arrays.asList(nums));

        for(int i=0;i<total;i++){

            String exp=Integer.toBinaryString(i);

            if(exp.length()!=n){
                int rep=n-exp.length();
                exp="0".repeat(rep)+exp;
            }
            
            if(!set.contains(exp)){
                ans=exp;
                break;
            }
        }
        return ans;
    }
}
