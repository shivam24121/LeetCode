class Solution {

    int n,m;
    int[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        n=nums1.length;
        m=nums2.length;

        dp=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans=solve(nums1,nums2,0,0);
        if(ans==0){
            ans=Integer.MIN_VALUE;
            for(int i=0;i<Math.min(m,n);i++){
                ans=Math.max(nums1[i]*nums2[i],ans);
            }
        }
        return ans;
    }
    public int solve(int[] a, int[] b, int i, int j){

        if(i>=n || j>=m)return Integer.MIN_VALUE/2;

        if(dp[i][j]!=-1)return dp[i][j];

        int take1=solve(a,b,i+1,j);
        int take2=solve(a,b,i,j+1);
        int takeBoth=Math.max(0,solve(a,b,i+1,j+1))+a[i]*b[j];

        return dp[i][j]=Math.max(take1, Math.max(take2,takeBoth));
        
    }
}
