class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()) return 0;
        int n=s.length();
        int fl=1;
        int i=0;

        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            if(s.charAt(i)=='-')fl=-1;
            i++;
        }
        long sum=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            sum=(sum*10)+(s.charAt(i)-'0');
            if(fl==-1 && sum>Integer.MAX_VALUE)return Integer.MIN_VALUE;
            if(fl==1 && sum>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            i++;
        }
        return (int)sum*fl;
    }
}
