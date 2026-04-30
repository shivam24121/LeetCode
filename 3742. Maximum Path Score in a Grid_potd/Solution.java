class Solution {

    int n;
    int m;
    int[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        
        n=grid.length;
        m=grid[0].length;

        dp=new int[n][m][k+1];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        int res=solve(0,0,k,grid);
        return res<0?-1:res;
    }
    public int solve(int x,int y,int k,int[][] grid){

        if(k<0){
            return Integer.MIN_VALUE/10;
        }
        int cost=grid[x][y]==2?1:grid[x][y];

        if(x==n-1 && y==m-1){
            return cost<=k?grid[x][y]:Integer.MIN_VALUE/10;
        }
        if(dp[x][y][k]!=-1){
            return dp[x][y][k];
        }

        int left=x+1<n?grid[x][y]+solve(x+1,y,k-cost,grid):Integer.MIN_VALUE/10;

        int right=y+1<m?grid[x][y]+solve(x,y+1,k-cost,grid):Integer.MIN_VALUE/10;

        return dp[x][y][k]=Math.max(left,right);
    }
}
