class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] c=s.toCharArray();
        int i=0;
        while(i<n){
            int j=Math.min(i+k-1,n-1);
            reverse(c,i,j);
            i+=2*k;
        }
        return new String(c);
    }
    public static void reverse(char[] c,int i,int j){
        while(i<=j){
            char t=c[i];
            c[i]=c[j];
            c[j]=t;
            i++;
            j--;
        }
    }
}
