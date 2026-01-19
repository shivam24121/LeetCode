class Solution {
    public int maxSideLength(int[][] mat, int limit) {
        int n=mat.length;
        int m=mat[0].length;

        int res=0;

        int[][] dp=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=mat[i][j]+
                         (i>0?dp[i-1][j]:0)+
                         (j>0?dp[i][j-1]:0)-
                         (i>0 && j>0?dp[i-1][j-1]:0);
            }
        }
        int best=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<Math.min(n-i,m-j);k++){
                    
                    int r2=i+k;
                    int c2=j+k;

                    int sum=dp[r2][c2]-
                            (i>0?dp[i-1][c2]:0)-
                            (j>0?dp[r2][j-1]:0)+
                            (i>0 && j>0?dp[i-1][j-1]:0);

                    if(sum<=limit){
                        best=Math.max(best,k+1);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return best;
    }
}
