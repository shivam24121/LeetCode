class Solution {
    
    ArrayList<ArrayList<int[]>> adj;
    boolean[] check;
    int[] res;

    public int[] minEdgeReversals(int n, int[][] edges) {
        adj=new ArrayList<>();
        check=new boolean[n];
        res=new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];

            adj.get(u).add(new int[]{v,0});
            adj.get(v).add(new int[]{u,1});
        }

        res[0]=dfs1(0);

        Arrays.fill(check,false);

        dfs2(0);

        return res;
    }
    public int dfs1(int u){
        check[u]=true;

        int cost=0;
        for(int[] e:adj.get(u)){
            int v=e[0];
            int w=e[1];
            if(check[v])continue;
            cost+=w+dfs1(v);
        }
        return cost;
    }
    public void dfs2(int u){
        check[u]=true;

        for(int[] e:adj.get(u)){
            int v=e[0];
            int w=e[1];
            if(check[v])continue;
            res[v]=res[u]+(w==0?1:-1);
            dfs2(v);
        }
    }
}
