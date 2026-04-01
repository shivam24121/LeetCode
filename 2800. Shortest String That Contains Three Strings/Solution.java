class Solution {
    public String minimumString(String a, String b, String c) {

        String ans = "z".repeat(301);

        ans = helper(ans, solve(new StringBuilder(a), new String[] { a, b, c }));
        ans = helper(ans, solve(new StringBuilder(a), new String[] { a, c, b }));
        ans = helper(ans, solve(new StringBuilder(b), new String[] { b, a, c }));
        ans = helper(ans, solve(new StringBuilder(b), new String[] { b, c, a }));
        ans = helper(ans, solve(new StringBuilder(c), new String[] { c, a, b }));
        ans = helper(ans, solve(new StringBuilder(c), new String[] { c, b, a }));

        return ans;
    }

    public String solve(StringBuilder sb, String[] arr) {
        for (int i = 1; i <= 2; i++) {
            String curr = arr[i];
            if(sb.indexOf(curr)!=-1)continue;
            int len=Math.min(sb.length(),curr.length());
            int match=0;
            for(int j=len;j>=1;j--){
                if(sb.substring(sb.length()-j).equals(curr.substring(0,j))){
                    match=j;
                    break;
                }
            }
            sb.append(curr.substring(match));
        }
            
        return sb.toString();
    }

    public String helper(String ans, String check) {

        if (ans.length() > check.length()) {
            ans = check;
        } else if (ans.length() == check.length()) {
            if (ans.compareTo(check) > 0) {
                ans = check;
            }
        }
        // System.out.println(check);
        return ans;

    }

}
