class Solution {
    public int numberOfSpecialChars(String s) {
        
        int n=s.length();
        Set<Character>set=new HashSet<>();

        for(char c:s.toCharArray()){
            set.add(c);
        }
        int res=0;

        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                if(set.contains(Character.toLowerCase(c))){
                    res++;
                    set.remove(Character.toLowerCase(c));
                    set.remove(Character.toUpperCase(c));
                }
            }
            else{
                if(set.contains(Character.toUpperCase(c))){
                    res++;
                    set.remove(Character.toUpperCase(c));
                    set.remove(Character.toLowerCase(c));
                }
            }
        }
        return res;
    }
}
