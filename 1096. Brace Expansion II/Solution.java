class Solution {
    String s;
    int i;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;
        Set<String> set = dfs();
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> dfs() {
        Set<String> res = new HashSet<>();
        Set<String> cur = new HashSet<>();
        cur.add("");

        while (i < s.length() && s.charAt(i) != '}') {
            char c = s.charAt(i);

            if (c == ',') {
                res.addAll(cur);
                cur = new HashSet<>();
                cur.add("");
                i++;
            } 
            else {
                Set<String> next;

                if (c == '{') {
                    i++;
                    next = dfs();
                    i++;
                } 
                else {
                    next = new HashSet<>();
                    next.add(String.valueOf(c));
                    i++;
                }

                Set<String> temp = new HashSet<>();

                for (String a : cur)
                    for (String b : next)
                        temp.add(a + b);

                cur = temp;
            }
        }

        res.addAll(cur);
        return res;
    }
}
