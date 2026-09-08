class Solution {
    public int countCommas(int n) {
        
        int res=1;

        if(n<1000){
            return 0;
        }
        res+=(n-1000);
        
        return res;
    }
}
