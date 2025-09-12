class Solution {
    public boolean isVowel(char c){
        return c=='a' || c=='i' || c=='o' || c=='e'|| c=='u';
    }
    public int beautifulSubstrings(String s, int k) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int vowel=0,cons=0;
            for(int j=i;j<s.length();j++){
                char c=s.charAt(j);
                if(isVowel(c)){
                    vowel++;
                }
                else{
                    cons++;
                }
                if(vowel==cons && (vowel*cons)%k==0){
                    res++;
                }
            }
        }
        return res;
    }
}
