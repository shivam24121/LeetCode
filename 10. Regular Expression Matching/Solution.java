class Solution {
    int[][] t;
    public boolean isMatch(String s, String p) {
        t=new int[21][21];
        for(int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                t[i][j]=-1;
            }
        }
        return solve(0,0,s,p);
    }
    public boolean solve(int i,int j,String s,String p){
        if(j==p.length()){
            return(i==s.length()); 
        }
        if(t[i][j]!=-1){
            return t[i][j]==1;
        }

        boolean ans=false;
        boolean first=(i<s.length() &&(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if(j+1<p.length() && p.charAt(j+1)=='*'){
            ans=(solve(i,j+2,s,p)||first && solve(i+1,j,s,p));
        }
        else{
            ans=first && solve(i+1,j+1,s,p);
        }
        return (t[i][j]=ans?1:0)==1;
    }
}
