class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String>res=new ArrayList<>();
        solve("",0,-1,n,res);
        Collections.sort(res);
        if(res.size()<k){
            return "";
        }
        return res.get(k-1);
    }
    public void solve(String curr,int idx,int prev,int n,ArrayList<String>res){
        if(curr.length()==n){
            res.add(curr);
            return;
        }
        for(int i=0;i<3;i++){
            if(i==prev)continue;
            solve(curr+(char)('a'+i),idx+1,i,n,res);
        }
    }
}
