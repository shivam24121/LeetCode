class Solution {
    public String reversePrefix(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s.substring(0,k));
        sb.reverse();
        sb.append(s.substring(k));
        return sb.toString();
    }
}©leetcode
