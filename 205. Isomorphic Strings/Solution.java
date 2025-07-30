class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sc=new int[256];
        int [] tc=new int[256];
        if(s.length()!=t.length())return false;
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if(sc[ss]!=tc[tt])return false;
                sc[ss]=i+1;
                tc[tt]=i+1; 
        }
        return true;
    }
}
