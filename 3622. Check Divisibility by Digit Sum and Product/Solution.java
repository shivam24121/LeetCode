class Solution {
    public boolean checkDivisibility(int n) {
        
        long product=1L;
        long sum=0;

        int temp=n;
        while(temp>0){
            int digit=temp%10;
            sum+=digit;
            product*=digit;
            temp/=10;
        }
        return (sum+product)%n==0;
    }
}
