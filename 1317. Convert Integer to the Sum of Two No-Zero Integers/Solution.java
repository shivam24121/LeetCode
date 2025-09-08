class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n-1;i++){
            if(isValid(i) && isValid(n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[]{};  
    }
    public boolean isValid(int n){
        while(n>0){
            int digit=n%10;
            if(digit==0){
                return false;
            }
            n/=10;
        }
        return true;
    }
}
