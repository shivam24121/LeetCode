class Solution {
    public int numSub(String s) {
        int n=s.length();
        int mod=(int)1e9+7;
        int ct=0;
        int res=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='1'){
                ct++;
                res=(res+ct)%mod;
            }
            else{
                ct=0;
            }
        }
        return res;
    }
}
