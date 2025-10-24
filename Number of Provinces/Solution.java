class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=isConnected.length;

        for(int i=0;i<n;i++){
            res.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    res.get(i).add(j);
                }
            }
        }
        int ct=0;

        boolean[] check=new boolean[n];
        for(int i=0;i<n;i++){
            if(!check[i]){
                dfs(res,i,check);
                ct++;
            }
        }
        return ct;
    }
    public void dfs(ArrayList<ArrayList<Integer>> res, int st, boolean[] check){
        check[st]=true;
        for(int i=0;i<res.get(st).size();i++){
            int curr=res.get(st).get(i);
            if(!check[curr]){
                dfs(res,curr,check);
            }
        }
    }
}
