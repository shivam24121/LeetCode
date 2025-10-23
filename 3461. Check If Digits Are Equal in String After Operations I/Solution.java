class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb=new StringBuilder(s);
        int n=s.length();
        while(n>2){
            for(int i=0;i<n-1;i++){
                int one=sb.charAt(i)-'0';
                int two=sb.charAt(i+1)-'0';
                int sum=(one+two)%10;
                sb.setCharAt(i,(char)(sum+'0'));
            }
            n--;
        }
        return sb.charAt(0)==sb.charAt(1);
    }
}
