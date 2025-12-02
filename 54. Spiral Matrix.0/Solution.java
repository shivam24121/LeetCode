class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;

        int top=0;
        int down=m-1;

        int left=0;
        int right=n-1;

        int dir=0;

        while(left<=right && top<=down){

            if(dir==0){
                for(int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if(dir==1){
                for(int i=top;i<=down;i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if(dir==2){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            if(dir==3){
                for(int i=down;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0;
            }
        }
        return res;
    }
}
