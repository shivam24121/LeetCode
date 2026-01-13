class Solution {

    int[][] dp;

    public int minInsertions(String s) {
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,s.length()-1);
    }
    public int solve(String s,int l,int r){

        if(l>=r)return 0;

        if(dp[l][r]!=-1)return dp[l][r];

        if(s.charAt(l)==s.charAt(r)){
            dp[l][r]=solve(s,l+1,r-1);
        }
        else{
            int skipL=1+solve(s,l,r-1);
            int skipR=1+solve(s,l+1,r);
            dp[l][r]=Math.min(skipL,skipR);
        }
        return dp[l][r];
    }
}
