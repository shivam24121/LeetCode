class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[2*n];
        int i=0;
        int j=n;

        for(int idx=0;idx<2*n;idx+=2){
            res[idx]=nums[i++];
            res[idx+1]=nums[j++];
        }
        return res;
    }
}
