class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];

        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                res[i]=-1;
                continue;
            }
            int j=1;
            while((nums.get(i) & (1<<j)) >0){
                j++;
            }
            int prev=j-1;
            int x=((nums.get(i)^(1<<prev)));
            res[i]=x;
        }
        return res;
    }
}
