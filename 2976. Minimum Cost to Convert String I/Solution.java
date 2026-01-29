class Solution {

    long inf=(long)1e15+7;

    public void populate(long[][] dp, char[] orig,char[] change,int[] cost){
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                dp[i][j]=inf;
                if(i==j){
                    dp[i][i]=0;
                }
            }
        }
        
        for(int i=0;i<orig.length;i++){
            int u=orig[i]-'a';
            int v=change[i]-'a';

            dp[u][v]=Math.min(dp[u][v],(long)cost[i]);
        }
        for(int via=0;via<26;via++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dp[i][via]!=inf && dp[via][j]!=inf){
                        dp[i][j]=Math.min(dp[i][j],dp[i][via]+dp[via][j]);
                    }
                }
            }
        }
    }

    public long minimumCost(String src, String x, char[] original, char[] changed, int[] cost) {

        long[][] dp=new long[26][26];
        populate(dp,original,changed,cost);

        long ans=0;

        for(int i=0;i<src.length();i++){
            int u=src.charAt(i)-'a';
            int v=x.charAt(i)-'a';

            if(u==v)continue;
            if(dp[u][v]==inf)return -1;

            ans+=dp[u][v];
        }
        return ans;
    }
}
