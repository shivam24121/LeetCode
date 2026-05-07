class Solution {
    public int[] maxValue(int[] nums) {
        
        int n=nums.length;

        int[] lmax=new int[n];
        int[] rmin=new int[n];

        int[] ans=new int[n];

        lmax[0]=nums[0];
        rmin[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            lmax[i]=Math.max(nums[i],lmax[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rmin[i]=Math.min(nums[i],rmin[i+1]);
        }
        ans[n-1]=lmax[n-1];

        for(int i=n-2;i>=0;i--){
            if(lmax[i]<=rmin[i+1]){
                ans[i]=lmax[i];
            }
            else{
                ans[i]=ans[i+1];
            }
        }
        return ans;
    }
}
