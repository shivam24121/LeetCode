class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode curr=head;
        int[][] matrix=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=-1;
            }
        }

        int top=0;
        int down=m-1;

        int left=0;
        int right=n-1;

        int dir=0;

        while(left<=right && top<=down && curr!=null){
            if(dir==0){
                for(int i=left;i<=right && curr!=null;i++){
                    matrix[top][i]=curr.val;
                    curr=curr.next;
                }
                top++;
            }
            if(dir==1){
                for(int i=top;i<=down && curr!=null;i++){
                    matrix[i][right]=curr.val;
                    curr=curr.next;
                }
                right--;
            }
            if(dir==2){
                for(int i=right;i>=left && curr!=null;i--){
                    matrix[down][i]=curr.val;
                    curr=curr.next;
                }
                down--;
            }
            if(dir==3){
                for(int i=down;i>=top && curr!=null;i--){
                    matrix[i][left]=curr.val;
                    curr=curr.next;
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0;
            }
        }
        return matrix;
    }
}
