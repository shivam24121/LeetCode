class Solution {
    public int countOdds(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++){
            if(odd(i)){
                res++;
            }
        }
        return res;
    }
    public boolean odd(int n){
        return (n&1)==1;
    }
}
