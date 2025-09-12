class Solution {
    public boolean isVowel(char c){
        c=Character.toLowerCase(c);
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    public boolean doesAliceWin(String s) {
        int ct=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(isVowel(c))ct++;
        }
        return ct>0;
    }
}
