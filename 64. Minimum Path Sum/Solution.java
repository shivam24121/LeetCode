class Solution {

    int[][] t;
    int m,n;

    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        t=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(t[i],-1);
        }

        return solve(grid,0,0);
    }
    public int solve(int[][] grid, int x,int y){
        if(x>=m || x<0 || y>=n || y<0)return Integer.MAX_VALUE;

        if(x==m-1 && y==n-1)return grid[x][y];

        if(t[x][y]!=-1)return t[x][y];

        int left=solve(grid,x+1,y);
        int right=solve(grid,x,y+1);

        return t[x][y]=Math.min(left,right)+grid[x][y];
    }
}
