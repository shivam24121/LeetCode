class Solution {
    public int mirrorDistance(int n) {
        
        int temp=n;
        int res=0;
        while(temp>0){
            int digit=temp%10;
            res=(res*10)+digit;
            temp/=10;
        }
        return Math.abs(n-res);
    }
}
