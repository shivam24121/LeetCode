class Solution {
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    public int maxFreqSum(String s) {
        int n=s.length();
        Map<Character,Integer> vow=new HashMap<>();
        Map<Character,Integer> cons=new HashMap<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(isVowel(c)){
                vow.put(c,vow.getOrDefault(c,0)+1);
            }
            else{
                cons.put(c,cons.getOrDefault(c,0)+1);
            }
        }
        int vct=0,cct=0;
        for(Map.Entry<Character,Integer> entry:vow.entrySet()){
            if(entry.getValue()>vct){
                vct=entry.getValue();
            }
        }
        for(Map.Entry<Character,Integer> entry:cons.entrySet()){
            if(entry.getValue()>cct){
                cct=entry.getValue();
            }
        }
        return vct+cct;
    }
}
