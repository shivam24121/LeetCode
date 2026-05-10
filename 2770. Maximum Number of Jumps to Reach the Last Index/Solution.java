class Solution {

    int[][] dp;

    public int maximumJumps(int[] nums, int target){

        int n=nums.length;

        dp=new int[n+1][n+1];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int ans=solve(1,0,nums,target);

        return ans<0?-1:ans;
    }
    public int solve(int idx,int prev,int[] nums,int target){

        if(prev==nums.length-1){
            return 0;
        }
        if(idx==nums.length){
            return Integer.MIN_VALUE;
        }
        if(dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int diff=Math.abs(nums[idx]-nums[prev]);

        int jump=Integer.MIN_VALUE;
        int skip=Integer.MIN_VALUE;

        if(diff<=target){

            jump=Math.max(jump,1+solve(idx+1,idx,nums,target));
        }
        
        skip=solve(idx+1,prev,nums,target);
        
        return dp[idx][prev]=Math.max(jump,skip);
    }
}
