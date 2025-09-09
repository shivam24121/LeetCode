class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod=(int)1e9+7;
        int[] t=new int[n+1];
        t[1]=1;
        for(int i=2;i<=n;i++){
            long ct=0;
            for(int j=i-forget+1;j<=i-delay;j++){
                if(j>0){
                    ct=(ct+t[j])%mod;
                }
            }
            t[i]=(int)ct;
        }
        int res=0;
        for(int i=n-forget+1;i<=n;i++){
            if(i>0){
                res=(res+t[i])%mod;
            }
        }
        return res;
    }
}
