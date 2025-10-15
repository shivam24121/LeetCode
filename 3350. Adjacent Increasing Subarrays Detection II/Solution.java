class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int curr=1;
        int prev=0;
        int k=0;

        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                curr++;
            }
            else{
                prev=curr;
                curr=1;
            }
            k=Math.max(k,curr/2);
            k=Math.max(k,Math.min(curr,prev));
        }
        return k;
    }
}
