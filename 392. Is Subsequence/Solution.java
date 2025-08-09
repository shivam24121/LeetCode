class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=0;
        int m=0;
        while(n<s.length() && m<t.length()){
            if(s.charAt(n)==t.charAt(m)){
                n++;
            }
            m++;
        }
        return n==s.length()?true:false;
    }
}
