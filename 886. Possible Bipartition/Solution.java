class Solution {

    int[] parent;
    int[] size;

    public void dsu(int n){
        parent=new int[2*n+1];
        size=new int[2*n+1];
        for(int i=0;i<=2*n;i++){
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
        u=find(u);
        v=find(v);

        if(u==v)return;

        if(size[u]>size[v]){
            parent[v]=parent[u];
            size[u]+=size[v];
        }
        else{
            parent[u]=parent[v];
            size[v]+=size[u];
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        dsu(n);

        for(int[] e:dislikes){
            int u=e[0];
            int v=e[1];

            if(find(u)==find(v))return false;

            union(u,v+n);
            union(v,u+n);
        }
        return true;
    }
}
