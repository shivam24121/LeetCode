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
        if(parent[u]!=u){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public void union(int u,int v){
        int uu=find(u);
        int vv=find(v);

        if(uu==vv)return;
        if(size[uu]>size[vv]){
            parent[vv]=uu;
            size[uu]+=size[vv];
        }
        else{
            parent[uu]=vv;
            size[vv]+=size[uu];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int component=0,extra=0;
        DSU(n);

        for(int[] e:connections){
            int u=e[0];
            int v=e[1];
            if(find(u)==find(v)){
                extra++;
            }
            else{
                union(u,v);
            }
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                component++;
            }
        }
        return component>extra+1?-1:component-1;
    }
}
