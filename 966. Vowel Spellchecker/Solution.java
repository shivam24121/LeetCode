class Solution {
    Set<String> exact=new HashSet<>();
    Map<String,String>caseMap=new HashMap<>();
    Map<String,String> vowel=new HashMap<>();

    public String lowerCase(String s){
        return s.toLowerCase();
    }

    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public String mask(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(isVowel(c)){
                sb.append('*');
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String match(String s){
        if(exact.contains(s)){
            return s;
        }
        String temp=lowerCase(s);
        if(caseMap.containsKey(temp)){
            return caseMap.get(temp);
        }

        String special=mask(temp);
        if(vowel.containsKey(special)){
            return vowel.get(special);
        }
        return "";
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        for(String s:wordlist){
            exact.add(s);

            String a=lowerCase(s);
            caseMap.putIfAbsent(a,s);

            String b=mask(a);
            vowel.putIfAbsent(b,s);
        }
        String[] str=new String[queries.length];
        for(int i=0;i<str.length;i++){
            str[i]=match(queries[i]);
        }
        return str;
    }
}
