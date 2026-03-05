class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ct0=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(s.charAt(i)=='1'){
                    ct0++;
                }
            }
            else{
                if(s.charAt(i)=='0'){
                    ct0++;
                }
            }
        }
        return Math.min(ct0,n-ct0);
    }
}
