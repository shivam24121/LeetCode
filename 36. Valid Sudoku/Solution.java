class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c=='.')continue;
                if(set.contains(c)){
                    return false;
                }
                else{
                    set.add(c);
                }
            }
        }
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                char c=board[j][i];
                if(c=='.')continue;
                if(set.contains(c)){
                    return false;
                }
                else{
                    set.add(c);
                }
            }
        }
        for(int rs=0;rs<9;rs+=3){
            int re=rs+2;
            for(int cs=0;cs<9;cs+=3){
                int ce=cs+2;
                if(!solve(board,rs,re,cs,ce)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(char[][] board,int a,int b,int c,int d){
        Set<Character>set=new HashSet<>();
        for(int i=a;i<=b;i++){
            for(int j=c;j<=d;j++){
                char cr=board[i][j];
                if(cr=='.')continue;
                if(set.contains(cr)){
                    return false;
                }
                set.add(cr);
            }
        }
        return true;
    }
}
