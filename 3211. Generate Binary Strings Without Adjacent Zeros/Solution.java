class Solution {
    List<String> res;

    public List<String> validStrings(int n) {
        res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        dfs(sb,n);
        return res;
    }
    public void dfs(StringBuilder sb,int n){
        if(sb.length()==n){
            res.add(sb.toString());
            return;
        }
        else{
            sb.append(1);
            dfs(sb,n);
            sb.setLength(sb.length()-1);
            if(sb.length()==0 || sb.charAt(sb.length()-1)=='1'){
                sb.append(0);
                dfs(sb,n);
                sb.setLength(sb.length()-1);
            }
        }
    }
}
