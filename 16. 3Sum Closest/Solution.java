class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,ans=0;
        for(int i=0;i<=n-3;i++){
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<min){
                    min=Math.abs(target-sum);
                    ans=sum;
                }
                if(sum<target)j++;
                else k--;
            }
        }
        return ans;
    }
}
