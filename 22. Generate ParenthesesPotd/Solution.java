class Solution {
    public List<String> generateParenthesis(int n) {
        String curr="";
        List<String> res=new ArrayList<>();
        solve(curr,0,n,res);
        return res;
    }
    public void solve(String curr,int st,int n,List<String>res){
        if(curr.length()==2*n){
            if(isValid(curr)){
                res.add(curr);
            }
            return;
        }
        curr+='(';
        solve(curr,st+1,n,res);
        curr=curr.substring(0,curr.length()-1);
        curr+=')';
        solve(curr,st+1,n,res);
        curr=curr.substring(0,curr.length()-1);
    }
    public boolean isValid(String s){
        int ct=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')ct++;
            else{
                ct--;
                if(ct<0){
                    return false;
                }
            }
        }
        return ct==0;
    }
}
