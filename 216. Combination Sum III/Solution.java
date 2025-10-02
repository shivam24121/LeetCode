class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        solve(n,k,1,res,new ArrayList<>());
        return res;
    }
    public void solve(int n,int k,int st,List<List<Integer>>res,ArrayList<Integer>temp){
        if(n==0 && temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(n<0 || temp.size()>k)return;

        for(int i=st;i<=9;i++){
            temp.add(i);
            solve(n-i,k,i+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
