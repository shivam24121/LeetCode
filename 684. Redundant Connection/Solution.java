class Solution {

    int[] parent;
    public void DSU(int n){
        parent=new int[n+1];
  
        for(int i=0;i<=n;i++){
            parent[i]=i;
     
        }
    }
    public int find(int u){
        if(u!=parent[u]){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public void union(int u,int v){
        int uu=find(u);
        int vv=find(v);

        if(uu==vv){
            return;
        }
        parent[uu]=vv;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU(n);

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];

            if(find(u)==find(v)){
                return e;
            }
            union(u,v);
        }
        return new int[]{-1,-1};
    }
}
