class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid,0,0,grid.length,0);
    }
    public boolean isValid(int[][] grid,int i,int j,int n,int exp){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=exp){
            return false;
        }
        if(exp==n*n-1){
            return true;
        }

        boolean a1=isValid(grid,i-2,j+1,n,exp+1);
        boolean a2=isValid(grid,i-1,j+2,n,exp+1);
        boolean a3=isValid(grid,i+1,j+2,n,exp+1);
        boolean a4=isValid(grid,i+2,j+1,n,exp+1);
        boolean a5=isValid(grid,i+2,j-1,n,exp+1);
        boolean a6=isValid(grid,i+1,j-2,n,exp+1);
        boolean a7=isValid(grid,i-1,j-2,n,exp+1);
        boolean a8=isValid(grid,i-2,j-1,n,exp+1);

        return a1||a2||a3||a4||a5||a6||a7||a8;
    }
}
