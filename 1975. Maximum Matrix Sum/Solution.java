class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min=Integer.MAX_VALUE,sum=0;
        int n=matrix.length;
        int neg=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                sum+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        //System.out.println(sum+" "+min+" "+neg);

    return neg%2==1?sum-2*min:sum;
    }
}
