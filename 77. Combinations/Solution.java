class Solution {
    List<List<Integer>>l=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>temp=new ArrayList<>();
        solve(1,n,temp,k);
        return l;
    }
    public void solve(int idx,int n,List<Integer>temp,int k){
        if(k==0){
            l.add(new ArrayList<>(temp));
            return;
        }
        if(idx>n)return;

        temp.add(idx);
        solve(idx+1,n,temp,k-1);
        temp.remove(temp.size()-1);
        solve(idx+1,n,temp,k);
    }
}
