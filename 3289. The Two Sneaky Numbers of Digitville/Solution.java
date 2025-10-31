class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        int n=nums.length,idx=0;
        int[] freq=new int[n];

        for(int i:nums){
            freq[i]++;
        }

        for(int i=0;i<n;i++){
            if(freq[i]==2){
                res[idx++]=i;
            }
        }
        return res;
    }
}
