class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int idx=0;

        int[] res=new int[n];

        for(int i=0;i<n;i++){
            int curr=i;
            if(nums[i]>=0){
                int next=(curr+nums[i])%n;
                res[idx++]=nums[next];
            }
            else{
                int val=Math.abs(nums[i]);
                int next=(curr-val+n)%n;
                res[idx++]=nums[(next+n)%n];
            }
        }
        return res;
    }
}
