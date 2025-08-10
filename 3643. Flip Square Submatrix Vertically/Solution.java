class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int a=0;a<k/2;a++){
            int top=x+a;
            int bottom=x+k-1-a;
            for(int i=y;i<y+k;i++){
                grid[top][i]=grid[top][i]+grid[bottom][i];
                grid[bottom][i]=grid[top][i]-grid[bottom][i];
                grid[top][i]=grid[top][i]-grid[bottom][i];
            }
        }
        return grid;
    }
}
