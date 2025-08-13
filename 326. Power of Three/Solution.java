class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        int max=1;
        while(max*3>0 && max*3<=Integer.MAX_VALUE){
            max*=3;
        }
        return max%n==0;
    }
}
