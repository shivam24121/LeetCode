class Solution {
    public int minLengthAfterRemovals(String s) {
        int n=s.length();
        int a=0,b=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='a')a++;
            else b++;
        }
        return Math.abs(a-b);
    }
}
