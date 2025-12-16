class Solution {
    List<List<Integer>>res=new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n=nums.length;
        Arrays.sort(nums);
        List<Integer>temp=new ArrayList<>();
        boolean[] visited=new boolean[n];
        solve(temp,nums,visited);
        return res;
    }
    public void solve(List<Integer>temp,int[] a,boolean[] visited){
        if(temp.size()==n ){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            if(i>0 && a[i]==a[i-1] && !visited[i-1])continue;

            temp.add(a[i]);
            visited[i]=true;

            solve(temp,a,visited);

            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}
