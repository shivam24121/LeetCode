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
    public boolean union(int u,int v){
        int uu=find(u);
        int vv=find(v);

        if(uu==vv)return false;
        if(uu<vv){
            parent[uu]=vv;
            size[vv]+=size[uu];
        }
        else{
            parent[vv]=uu;
            size[uu]+=vv;
        }
        return true;
    }
    public int minCost(int n, int[][] edges, int k) {
        DSU(n);
        if(n<=k)return 0;
        int component=n;
        Arrays.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];

            if(union(u,v)){
                component--;
            }
            if(component<=k){
                return w;
            }
        }
        return 0;
    }
}
