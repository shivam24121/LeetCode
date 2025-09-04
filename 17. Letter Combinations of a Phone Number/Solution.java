class Solution {
    List<String> l=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb=new StringBuilder();
        solve(0,digits,sb,map);
        return l;
    }
    public void solve(int idx,String digits,StringBuilder sb,Map<Character,String>map){
        if(idx>=digits.length()){
            l.add(sb.toString());
            return;
        }
        char c=digits.charAt(idx);
        String s=map.get(c);
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            solve(idx+1,digits,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
