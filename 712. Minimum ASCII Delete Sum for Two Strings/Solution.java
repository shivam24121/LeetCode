class Solution {

    int n;
    int m;
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2){

        n=s1.length();
        m=s2.length();

        dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s1,s2,0,0);
    }
    public int solve(String s1,String s2,int a,int b){
        if(a==n){
            int cost=0;
            for(int i=b;i<m;i++){
                cost+=s2.charAt(i);
            }
            return cost;
        }
        if(b==m){
            int cost=0;
            for(int i=a;i<n;i++){
                cost+=s1.charAt(i);
            }
            return cost;
        }
        if(dp[a][b]!=-1){
            return dp[a][b];
        }
        int skipA=0,skipB=0;

        if(s1.charAt(a)==s2.charAt(b)){
            return dp[a][b]=solve(s1,s2,a+1,b+1);
        }
        else{
            skipA=s1.charAt(a)+solve(s1,s2,a+1,b);
            skipB=s2.charAt(b)+solve(s1,s2,a,b+1);
        }
        return dp[a][b]=Math.min(skipA,skipB);
    }
}
