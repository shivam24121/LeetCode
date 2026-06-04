class Solution {

    int[] dx={1,0,0,-1};
    int[] dy={0,-1,1,0};
    int n;
    int m;

    public int numEnclaves(int[][] grid) {
        
        n=grid.length;
        m=grid[0].length;

        int res=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    dfs(i,j,grid);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int x,int y,int[][] grid){

        if(x<0 || x==n || y<0 || y==m || grid[x][y]!=1){
            return;
        }
        grid[x][y]=0;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            dfs(xx,yy,grid);
        }
    }
}
