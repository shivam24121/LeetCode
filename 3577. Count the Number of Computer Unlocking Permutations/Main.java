class Solution {
    public int countPermutations(int[] a) {
        int mod=(int)1e9+7;
        long res=1;
        int n=a.length;
        for(int i=1;i<n;i++){
            if(a[i]<=a[0]){
                return 0;
            }
        }
        for(int i=1;i<n;i++){
            res=(res*i)%mod;
        }
        return (int)res;
    }
}
