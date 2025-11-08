class Solution {

    int mod=(int)1e9+7;
    int[][][] t;

    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        t=new int[m+1][n+1][k+1];
        for(int a=0;a<=m;a++){
            for(int b=0;b<=n;b++){
                for(int c=0;c<=k;c++){
                    t[a][b][c]=-1;
                }
            }
        }
        return solve(grid,0,0,m,n,k,grid[0][0]);
    }
    public int solve(int[][] grid,int x,int y,int m,int n,int k,int sum){
        if(x<0 || x>=m || y<0 || y>=n)return 0;

        if(t[x][y][sum%k]!=-1)return t[x][y][sum%k];

        if(x==m-1 && y==n-1 && sum%k==0)return 1;

        int left=x+1<m?solve(grid,x+1,y,m,n,k,sum+grid[x+1][y]):0;
        int right=y+1<n?solve(grid,x,y+1,m,n,k,sum+grid[x][y+1]):0;

        return t[x][y][sum%k]=(left+right)%mod;
    }
}
