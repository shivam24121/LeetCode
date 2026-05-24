class Solution {
    public int maxJumps(int[] arr, int k) {
        
        int n=arr.length;

        int[] dp=new int[n];

        Arrays.fill(dp,-1);

        int ans=0;

        for(int i=0;i<n;i++){
            ans=Math.max(ans,solve(i,arr,k,dp));
        }
        return ans;
    }
    public int solve(int idx,int[] arr,int k,int[] dp){

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ans=1;

        for(int i=idx+1;i<=Math.min(idx+k,arr.length-1);i++){
            if(arr[idx]<=arr[i]){
                break;
            }
            ans=Math.max(ans,1+solve(i,arr,k,dp));
        }
        for(int i=idx-1;i>=Math.max(0,idx-k);i--){
            if(arr[idx]<=arr[i]){
                break;
            }
            ans=Math.max(ans,1+solve(i,arr,k,dp));
        }
        return dp[idx]=ans;
    }
}
