class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            set.add(c);
        }
        int res=0;
        for(char c:set){
            int first=-1;
            int second=-1;
            for(int i=0;i<n;i++){
                if(s.charAt(i)==c){
                    if(first==-1){
                        first=i;
                    }
                    second=i;
                }
            }
            Set<Character>mid=new HashSet<>();
            for(int i=first+1;i<=second-1;i++){
                mid.add(s.charAt(i));
            }
            res+=mid.size();
        }
        return res;
    }
}
