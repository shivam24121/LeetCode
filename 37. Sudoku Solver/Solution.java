class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){  
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if (board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,row,col,c)){
                            board[row][col]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[row][col]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][]board,int row,int col,int val){
        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                return false;
            }
            if(board[i][col]==val){
                return false;
            }
        }
        int rowst=(row/3)*3;
        int colst=(col/3)*3;
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                if(board[rowst+a][colst+b]==val){
                    return false;
                }
            }
        }
        return true;
    }
}
