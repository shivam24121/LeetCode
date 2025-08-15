class Solution {
    public boolean isPowerOfFour(int n) {
        return n>0 && 1073741824%n==0 && ((n-1)%3==0);
    }
}
