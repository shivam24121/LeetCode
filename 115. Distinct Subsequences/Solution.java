class Solution {

    int[][] dp;
    int n;
    int m;
    int inf=(int)1e9;

    public int numDistinct(String s, String t) {
        
        n=s.length();
        m=t.length();

        if(m>n){
            return 0;
        }

        dp=new int[n+1][m+1];

        for(int[] a:dp){
            Arrays.fill(a,inf);
        }
        return solve(0,0,s,t);
    }
    public int solve(int i,int j,String a,String b){

        if(i==n){
            return j==m?1:0;
        }
        if(j==m)return 1;
        
        if(n-i<m-j){
            return 0;
        }
        if(dp[i][j]!=inf){
            return dp[i][j];
        }
        int skip=solve(i+1,j,a,b);

        int pick=0;

        if(a.charAt(i)==b.charAt(j)){
            pick=solve(i+1,j+1,a,b);
        }
        return dp[i][j]=pick+skip;
    }
}
