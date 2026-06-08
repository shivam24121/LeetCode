class Solution {
    public String shortestPalindrome(String s) {
        
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        String ss=s+"*"+rev;

        int[] lps=kmp(ss);
        StringBuilder sb=new StringBuilder();

        StringBuilder res=new StringBuilder();
        int max=lps[lps.length-1];

        String temp=new StringBuilder(s.substring(max)).reverse().toString();
        res.append(temp).append(s);

        return res.toString();
    }
    public int[] kmp(String s){

        int n=s.length();
        int len=0;
        int i=1;
        int[] lps=new int[n];

        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else if(len>0 && s.charAt(i)!=s.charAt(len)){
                len=lps[len-1];
            }
            else{
                len=0;
                i++;
            }
        }
        return lps;
    }
}
