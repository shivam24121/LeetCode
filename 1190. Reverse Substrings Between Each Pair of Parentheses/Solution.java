class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String cur = "";

        for(char c : s.toCharArray()) {
            if(c == '(') {
                st.push(cur);
                cur = "";
            } else if(c == ')') {
                cur = new StringBuilder(cur).reverse().toString();
                cur = st.pop() + cur;
            } else {
                cur += c;
            }
        }

        return cur;
    }
}
