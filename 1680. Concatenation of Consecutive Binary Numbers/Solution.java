class Solution {
    public int concatenatedBinary(int n) {
        long ans=0;
        int mod=(int)1e9+7;

        int curr=0;
        
        for(int i=1;i<=n;i++){

            if((i&(i-1))==0)curr++;

            ans=((ans<<curr)%mod+i)%mod;
        }
        
        return (int)ans;
    }
}
