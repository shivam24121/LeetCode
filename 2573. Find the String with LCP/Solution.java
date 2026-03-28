class Solution {
    public String findTheString(int[][] lcp) {
        int n=lcp.length;
        char[] res=new char[n];

        Arrays.fill(res,'*');
        char curr='a';

        for(int i=0;i<n;i++){

            if(lcp[i][i]!=n-i)return "";

            if(curr>'z')return "";

            if(res[i]!='*')continue;

            res[i]=curr;

            for(int j=0;j<n;j++){
                if(lcp[i][j]>0){
                    res[j]=curr;
                }
            }
            curr++;
        }
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(res[i]==res[j]){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]=0;
                }
                if(dp[i][j]!=lcp[i][j])return "";
            }
        }
        return new String(res);
    }
}
