class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] check=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board,word,check,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board,String word,boolean[][] check,int i,int j,int idx){
        if(idx==word.length())return true;

        if(i<0 ||i>=board.length ||j<0 || j>=board[0].length ||
           check[i][j] || board[i][j]!=word.charAt(idx))return false;

        check[i][j]=true;

        if(
            solve(board,word,check,i+1,j,idx+1) ||
            solve(board,word,check,i-1,j,idx+1) ||
            solve(board,word,check,i,j+1,idx+1) ||
            solve(board,word,check,i,j-1,idx+1)
        )
        return true;

        check[i][j]=false;
        return false;

    }
}
