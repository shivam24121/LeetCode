class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Map<Character,Integer> hm=new HashMap<>();
        int l=0;
        int res=0;
        for(int r=0;r<n;r++){
            if(!hm.containsKey(s.charAt(r)) || hm.get(s.charAt(r))<l){
                hm.put(s.charAt(r),r);
                res=Math.max(res,r-l+1);
            }
            else{
                l=hm.get(s.charAt(r))+1;
                hm.put(s.charAt(r),r);
            }
        }
        return res;
    }
}
