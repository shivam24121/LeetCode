class Solution {
    int res;
    public int minScore(int n, int[][] roads) {
        res=Integer.MAX_VALUE;

        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:roads){
            
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        boolean[] vis=new boolean[n+1];

        dfs(1,0,adj,vis);
        return res;
    }
    public void dfs(int u,int par,ArrayList<ArrayList<int[]>>adj,boolean[] vis){

        vis[u]=true;

        for(int[] neigh:adj.get(u)){

            if(neigh[0]==par)continue;
            res=Math.min(res,neigh[1]);

            if(!vis[neigh[0]]){
                dfs(neigh[0],u,adj,vis);
            }
        }
    }
}
