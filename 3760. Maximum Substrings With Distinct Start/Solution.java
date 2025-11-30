class Solution {
    public int maxDistinct(String s) {
        int n=s.length();
        Set<Character>set=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        } 
        return set.size();
    }
}
