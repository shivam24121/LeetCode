class Solution {

    int[] parent;
    int[] size;

    public void DSU(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
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

        if(uu==vv)return;

        if(size[uu]<size[vv]){
            parent[uu]=vv;
            size[vv]+=size[uu];
        }
        else{
            parent[vv]=uu;
            size[uu]+=size[vv];
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU(n);
        
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            union(u,v);
        }
        return find(source)==find(destination);
    }
}
