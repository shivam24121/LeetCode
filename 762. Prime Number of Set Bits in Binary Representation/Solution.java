class Solution {
    public int countPrimeSetBits(int left, int right) {

        int ct=0;
        for(int i=left;i<=right;i++){
            int bit=Integer.bitCount(i);
            if(isPrime(bit))ct++;
        }
        return ct;
    }
    public boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
