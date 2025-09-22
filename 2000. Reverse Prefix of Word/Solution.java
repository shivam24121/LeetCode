class Solution {
    public String reversePrefix(String word, char ch) {
        int pos=word.indexOf(ch);
        if(ch<0){
            return word;
        }
        return new StringBuilder(word.substring(0,pos+1)).reverse().toString()+word.substring(pos+1);
    }
}
