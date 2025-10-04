class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        dp=new int[row][col][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<col;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return solve(grid,0,0,col-1,row,col); 
    }
    public int solve(int[][]grid,int r,int c1,int c2,int row,int col){
        if(c1<0 || c2<0 || c1>=col || c2>=col)return 0;
        if(dp[r][c1][c2]!=-1)return dp[r][c1][c2];
        if(r==row-1){
            if(c1==c2)return grid[r][c1];
            else return grid[r][c1]+grid[r][c2];
        }

        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int next=solve(grid,r+1,c1+i,c2+j,row,col);
                max=Math.max(max,next);
            }
        }
        int curr=0;
        if(c1==c2) curr=grid[r][c1];
        else curr=grid[r][c1]+grid[r][c2];
        dp[r][c1][c2]=curr+max;
        return max+curr;
    }
}
