class Solution {
    public int minOperations(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int diff=(26-(c-'a'))%26;
            res=Math.max(res,diff);
        }
        return res;
    }
}
