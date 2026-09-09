class Solution {
    public long countCommas(long n) {
        
        long res=0;

        long val=1000;

        while(val<=n){
            res+=(n-val+1);
            val*=1000;
            System.out.println(val);
        }
        return res;
    }
}
