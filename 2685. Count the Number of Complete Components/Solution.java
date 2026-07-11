class Solution {

    int[] parent;
    int[] size;
    int[] edge;

    void DSU(int n){
        
        parent=new int[n];
        size=new int[n];
        edge=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int u){
        if(u!=parent[u]){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    void union(int u,int v){

        u=find(u);
        v=find(v);

        edge[u]++;
        // edge[v]++;

        if(u==v){
            return;
        }

        if(size[u]>=size[v]){
            parent[v]=u;
            size[u]+=size[v];
            edge[u]+=edge[v];
        }
        else{
            parent[u]=v;
            size[v]+=size[u];
            edge[v]+=edge[u];
        }
    }
    public int countCompleteComponents(int n, int[][] edges){
        
        DSU(n);

        int component=0;

        for(int[] e:edges){

            int u=e[0];
            int v=e[1];

            union(u,v);
        }
        for(int i=0;i<n;i++){
            // System.out.println(parent[i]+" "+size[i]+" "+edge[i]);
            if(parent[i]==i){
                if(edge[i]==((size[i]*(size[i]-1))/2)){
                    component++;
                }
            }
        }
        return component;
    }
}
