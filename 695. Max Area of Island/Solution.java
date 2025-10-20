class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int x,int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=1){
            return 0;
        }
        grid[x][y]=5;    //any number except 1;
        int area=1;
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            area+=dfs(grid,xx,yy);
        }
        return area;
    }
}
