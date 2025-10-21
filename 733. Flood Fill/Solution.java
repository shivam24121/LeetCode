class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og=image[sr][sc];
        if(og!=color){
            dfs(image,sr,sc,og,color);
        }
        return image;
    }
    public void dfs(int[][] grid,int x,int y,int og,int val){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=og){
            return;
        }
        grid[x][y]=val;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            dfs(grid,xx,yy,og,val);
        }
    }
}
