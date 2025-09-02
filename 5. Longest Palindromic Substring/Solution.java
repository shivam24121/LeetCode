class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=Integer.MIN_VALUE;
        int st=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j) && j-i+1>len){
                    len=j-i+1;
                    st=i;
                }
            }
        }
        return s.substring(st,st+len);

    }
    public boolean solve(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
