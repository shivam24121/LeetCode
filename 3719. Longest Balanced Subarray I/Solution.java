class Solution {
    public int longestBalanced(int[] nums) {
        int res=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            Set<Integer>even=new HashSet<>();
            Set<Integer>odd=new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j]%2==0){
                    even.add(nums[j]);
                }
                else{
                    odd.add(nums[j]);
                }
                if(even.size()==odd.size()){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}
