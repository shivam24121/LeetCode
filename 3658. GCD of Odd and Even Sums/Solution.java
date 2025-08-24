class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd=0,even=0;
        for(int i=1;i<n*2;i++){
            if((i&1)==1){
                odd+=i;
            }
            else{
                even+=i;
            }
        }
        return gcd(odd,even);
        
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
