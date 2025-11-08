class Solution {
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        solve(board,0,res);
        return res;
    }
    public void solve(char[][] board,int idx,List<List<String>> res){
        if(idx==n){
            res.add(genrate(board));
            return;
        }

        for(int col=0;col<n;col++){
            if(valid(board,idx,col)){
                board[idx][col]='Q';
                solve(board,idx+1,res);
                board[idx][col]='.';
            }
        } 
    }
    public boolean valid(char[][] board,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1 , j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> genrate(char[][] board){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new String(board[i]));
        }
        return temp;
    }
}
