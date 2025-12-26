class Solution {

    int n;
    ArrayList<ArrayList<Integer>>adj;
    int[] subTree;
    int[] res;
    boolean[] visited;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n=n;
        adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        subTree=new int[n];
        res=new int[n];
        visited=new boolean[n];

        dfs1(0,-1);

        // for(int i=0;i<n;i++){
        //     System.out.print(subTree[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.print(res[i]+" ");
        // }
        dfs2(0,-1);

        return res;
    }
    public void dfs1(int u,int parent){
        subTree[u]=1;

        for(int neigh:adj.get(u)){
            if(neigh==parent)continue;

            dfs1(neigh,u);
            subTree[u]+=subTree[neigh];
            res[0]+=subTree[neigh];
        }
    }
    public void dfs2(int u,int parent){
        visited[u]=true;
        for(int neigh:adj.get(u)){
            if(neigh==parent)continue;

            res[neigh]=res[u]-subTree[neigh]+(n-subTree[neigh]);
            dfs2(neigh,u);
        }
    }
}
