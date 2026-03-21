class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n=grid.length;
        int m=grid[0].length;
        for(int j=y;j<y+k;j++){
            int l=x,r=x+k-1;
            while(l<r){
                int temp=grid[l][j];
                grid[l][j]=grid[r][j];
                grid[r][j]=temp;
                l++;
                r--;
            }
        }
        return grid;
    }
}
