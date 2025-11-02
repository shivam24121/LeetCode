class Solution {

    int[] dx={1,0,0,-1};
    int[] dy={0,-1,1,0};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];

        for(int i=0;i<guards.length;i++){
            int r=guards[i][0];
            int c=guards[i][1];
            grid[r][c]=2;
        }
        for(int i=0;i<walls.length;i++){
            int r=walls[i][0];
            int c=walls[i][1];
            grid[r][c]=2;
        }

        for(int i=0;i<guards.length;i++){
            int r=guards[i][0];
            int c=guards[i][1];
            for(int j=0;j<4;j++){
                int x=dx[j];
                int y=dy[j];

                int xx=r+x;
                int yy=c+y;
                while(xx>=0 && xx<m && yy>=0 && yy<n && grid[xx][yy]!=2){
                    grid[xx][yy]=1;
                    xx+=x;
                    yy+=y;
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)res++;
            }
        }
        return res;
    }
}
