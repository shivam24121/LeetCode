class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    int temp=dfs(grid,i,j);
                    if(temp%k==0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid,int x,int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0){
            return 0;
        }
        int res=grid[x][y];
        grid[x][y]=0;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            res+=dfs(grid,xx,yy);
        }
        return res;
    }
}
