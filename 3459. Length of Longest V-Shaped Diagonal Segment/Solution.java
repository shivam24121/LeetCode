class Solution {

    int m,n;
    int[][] dir={{1,1},{1,-1},{-1,-1},{-1,1}};
    int[][][][] t;

    public int lenOfVDiagonal(int[][] grid) {
       m=grid.length;
       n=grid[0].length;
       t=new int[m][n][4][2];

       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<4;k++){
                for(int l=0;l<2;l++){
                    t[i][j][k][l]=-1;
                }
            }
        }
       }
       int res=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                for(int k=0;k<4;k++){
                    res=Math.max(res,1+solve(i,j,k,1,grid,2));
                }
            }
        }
       }
       return res;
    }
    public int solve(int i,int j,int k,int turn,int[][]grid,int val){
        int ii=i+dir[k][0];
        int jj=j+dir[k][1];

        if(ii>=m || ii<0 || jj>=n || jj<0 || grid[ii][jj]!=val){
            return 0;
        }

        if(t[ii][jj][k][turn]!=-1){
            return t[ii][jj][k][turn];
        }

        int next=(val==2)?0:2;
        int res=0;
        int keepsolve=1+solve(ii,jj,k,turn,grid,next);
        res=Math.max(res,keepsolve);

        if(turn==1){
            int turnsolve=1+solve(ii,jj,(k+1)%4,0,grid,next);
            res=Math.max(res,turnsolve);
        }
        return t[ii][jj][k][turn]=res;
    }
}
