class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=matrix[row2][col2];
        int extra=(row1>0?matrix[row1-1][col2]:0)+
                  (col1>0?matrix[row2][col1-1]:0)-
                  (row1>0 && col1>0?matrix[row1-1][col1-1]:0);
        
        return sum-extra;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
