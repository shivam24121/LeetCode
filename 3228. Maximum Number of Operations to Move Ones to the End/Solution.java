class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int one=0;
        int res=0;
        int i=0;

        while(i<n){
            char c=s.charAt(i);
            if(c=='0'){
                while(i<n && s.charAt(i)=='0'){
                    i++;
                }
                res+=one;
            }
            else{
                one++;
                i++;
            }
        }
        return res;
    }
}
