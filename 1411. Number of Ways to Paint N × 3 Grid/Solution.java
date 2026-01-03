class Solution {
    public int numOfWays(int n){
        int mod=(int)1e9+7;
        long two=6,three=6;
        n--;

        while(n>0){
            long next=(3*two+2*three)%mod;
            three=(2*three+2*two)%mod;
            two=next;
            n--;
        }
        return (int)(two+three)%mod;
    }
}
