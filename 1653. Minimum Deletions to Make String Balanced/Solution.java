class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();

        int rA=0;
        int res=Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='a'){
                rA++;
            }
        }
        int lB=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                rA--;
            }
            res=Math.min(res,rA+lB);

            if(s.charAt(i)=='b'){
                lB++;
            }
        }
        return res;
    }
}
