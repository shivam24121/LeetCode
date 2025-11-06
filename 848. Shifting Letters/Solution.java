class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] c=s.toCharArray();
        int sum=0;

        for(int i=s.length()-1;i>=0;i--){
            sum=(sum+shifts[i])%26;
            c[i]=(char)('a'+((c[i]+sum-'a')%26));
        }
        return new String(c);
    }
}
