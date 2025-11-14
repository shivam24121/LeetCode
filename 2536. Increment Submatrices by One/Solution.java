class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid=new int[n][n];

        for(int[] e:queries){
            int r1=e[0];
            int c1=e[1];
            int r2=e[2];
            int c2=e[3];

            for(int i=r1;i<=r2;i++){
                grid[i][c1]++;
                if(c2+1<n){
                    grid[i][c2+1]--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                grid[i][j]+=grid[i][j-1];
            }
        }
        return grid;
    }
}
