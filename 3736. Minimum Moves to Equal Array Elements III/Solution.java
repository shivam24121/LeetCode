class Solution {
    public int minMoves(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int res=0;
        for(int i:nums){
            res+=max-i;
        }
        return res;
    }
}
