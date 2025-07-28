class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;
        boolean[] arr=prime(n);
        long suma=0,sumb=0;
        for(int i=0;i<n;i++){
            if(arr[i])suma+=nums[i];
            else sumb+=nums[i];
        }
        return Math.abs(suma-sumb);
    
       
    }
    public static boolean[] prime(int n){
        boolean [] isprime=new boolean[n];
        Arrays.fill(isprime,true);
        if(n>0)isprime[0]=false;
        if(n>1)isprime[1]=false;
        for(int i=2;i*i<n;i++){
            if(isprime[i]){
                for(int j=i*i;j<n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        return isprime;
    }
}
