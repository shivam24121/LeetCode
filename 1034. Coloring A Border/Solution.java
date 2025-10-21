class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] check=new boolean[m][n];
        int og=grid[row][col];
        
        dfs(grid,check,row,col,og);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<0){
                    grid[i][j]=color;
                }
            }
        }
        return grid;
    }
    public void dfs(int[][] grid,boolean[][] check,int x,int y,int val){
        check[x][y]=true;
        boolean fl=false;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if(xx<0 || xx>=grid.length || yy<0 || yy>=grid[0].length){
                fl=true;
            }
            else if(Math.abs(grid[xx][yy])!=val){
                fl=true;
            }
            else if(!check[xx][yy]){
                dfs(grid,check,xx,yy,val);
            }
        }
        if(fl){
            grid[x][y]=-val;
        }
    }
}


/*  1 1    3 3
    1 2    3 2

    1 2 2   1 3 3
    2 3 2   2 3 3

    1 1 1  2 2 2
    1 1 1  2 1 2
    1 1 1  2 2 2
*/
