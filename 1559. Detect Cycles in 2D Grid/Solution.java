class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] check=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='1'){
                    char c=grid[i][j];
                    if(dfs(grid,i,j,-1,-1,c,check)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] grid,int x,int y,int px,int py,char c,boolean[][] check){
        check[x][y]=true;
        
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if(xx<0 || xx>=grid.length || yy<0 || yy>=grid[0].length)continue;
            if(grid[xx][yy]!=c)continue;

            if(!check[xx][yy]){
                if(dfs(grid,xx,yy,x,y,c,check)){
                    return true;
                }
            }
            else if(xx!=px || yy!=py){
                return true;
            }
        }
        return false;
    }
}
