class Solution {
    public boolean isVowel(char c){
        c=Character.toLowerCase(c);
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    public String sortVowels(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(isVowel(c)){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        String sorted="AEIOUaeiou";
        int j=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(isVowel(c)){
                while(j<sorted.length() && map.getOrDefault(sorted.charAt(j),0)==0){
                    j++;
                }
                if(j<sorted.length()){
                    sb.setCharAt(i,sorted.charAt(j));
                    map.put(sorted.charAt(j),map.getOrDefault(sorted.charAt(j),0)-1);
                }
            }
        }
        return sb.toString();
    }
}
