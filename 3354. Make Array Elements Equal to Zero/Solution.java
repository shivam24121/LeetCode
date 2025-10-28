class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int ct=0;
        int sum=Arrays.stream(nums).sum();

        int curr=0;
        for(int i:nums){
            if(i==0){
                if(curr>=sum && curr-sum<=1){
                    ct++;
                }
                if(sum>=curr && sum-curr<=1){
                    ct++;
                }
            }
            curr+=i;
            sum-=i;
        }
        return ct;
    }
}
