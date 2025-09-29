class Solution {

    int[][] dp;

    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        dp=new int[51][51];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(values,0,n-1);
    }
    public int solve(int[] a,int i,int j){
        if(j-i+1<3)return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int temp=a[i]*a[j]*a[k]+solve(a,i,k)+solve(a,k,j);
            res=Math.min(res,temp);
        }
        return dp[i][j]=res;
    }
}
