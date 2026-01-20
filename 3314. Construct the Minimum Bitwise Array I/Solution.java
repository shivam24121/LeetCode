class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res=new int[nums.size()];
        boolean fl=false;

        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==2){
                res[i]=-1;
                continue;
            }
            for(int j=1;j<32;j++){
                if((nums.get(i) & 1<<j)>0){
                    continue;
                }
                int prev=j-1;
                int x=nums.get(i)^(1<<prev);
                res[i]=x;
                fl=true;
                break;
            }
        }
        return res;
    }
}
