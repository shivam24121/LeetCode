class Solution {

    int[][] t;
    int mod=(int)1e9+7;
    int m,n;

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public int countPaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        t=new int[1001][1001];

        for(int i=0;i<m;i++){
            Arrays.fill(t[i],-1);
        }
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=(res+dfs(grid,i,j))%mod;
            }
        }
        return res;
    }
    public int dfs(int[][] grid,int x,int y){
        int res=1;
        if(t[x][y]!=-1)return t[x][y];

        for(int i=0;i<4;i++){
            int xx=dx[i]+x;
            int yy=dy[i]+y;

            if(xx>=0 && xx<m && yy>=0 && yy<n && grid[x][y]<grid[xx][yy]){
                res=(res+dfs(grid,xx,yy))%mod;
            }
        }
        return t[x][y]=res;
    }
}
