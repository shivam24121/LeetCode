class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        long sum = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int[] i : grid){
            for(int j : i){
                sum += j;
            }
        }

        if(n == 1){
            long temp = 0;
            for(int i = 0; i < m; i++){
                temp += grid[0][i];
                if(temp == (sum - temp)){
                    return true;
                }
            }
        }

        if(m == 1){
            long temp = 0;
            for(int i = 0; i < n; i++){
                temp += grid[i][0];
                if(temp == (sum - temp)){
                    return true;
                }
            }
        }

        long rowSum = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                rowSum += grid[i][j];
            }
            if(rowSum == sum - rowSum){
                return true;
            }
        }

        long colSum = 0;
        for(int j = 0; j < m - 1; j++){
            for(int i = 0; i < n; i++){
                colSum += grid[i][j];
            }
            if(colSum == sum - colSum){
                return true;
            }
        }

        return false;
    }
}
