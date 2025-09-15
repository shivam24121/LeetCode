class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] str=text.split("\\s+");
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            char c=brokenLetters.charAt(i);
            set.add(c);
        }
        int res=0;
        for(int i=0;i<str.length;i++){
            boolean fl=true;
            for(int j=0;j<str[i].length();j++){
                char c=str[i].charAt(j);
                if(set.contains(c)){
                    fl=false;
                    break;
                }
            }
            if(fl)res++;
        }
        return res;
    }
}
