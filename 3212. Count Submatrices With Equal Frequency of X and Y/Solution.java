class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int ct=0;

        int[][] prefixX=new int[n][m];
        int[][] prefixY=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    prefixX[i][j]++;
                }
                else if(grid[i][j]=='Y'){
                    prefixY[i][j]++;
                }
                if(i>0){
                    prefixX[i][j]+=prefixX[i-1][j];
                    prefixY[i][j]+=prefixY[i-1][j];
                }
                if(j>0){
                    prefixX[i][j]+=prefixX[i][j-1];
                    prefixY[i][j]+=prefixY[i][j-1];
                }
                if(i>0 && j>0){
                    prefixX[i][j]-=prefixX[i-1][j-1];
                    prefixY[i][j]-=prefixY[i-1][j-1];
                }
                if(prefixX[i][j]==prefixY[i][j] && prefixX[i][j]>0){
                    ct++;
                }
            }
        }
        return ct;
    }
}
