class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n*n,n*(n+1));
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
