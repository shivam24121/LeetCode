class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        int[] res=new int[n+1];
        Arrays.fill(res,1);

        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                res[i+1]+=res[i];
            }
        }
        for(int i=k;i+k<=n;i++){
            if(res[i]>=k && res[i+k]>=k)return true;
        }
        return false;
    }
}
