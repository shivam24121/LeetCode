class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();

        if(num.length()==k)return "0";
        for(char c:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peekLast()>c){
                st.pollLast();
                k--;
            }
            st.offerLast(c);
        }
        while(k>0 && !st.isEmpty()){
            st.pollLast();
            k--;
        }
        while(!st.isEmpty()){
            sb.append(st.pollFirst());
        }
        while(sb.length()>1 && sb.charAt(0)=='0')sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }
}
