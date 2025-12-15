class Solution {

    int[] parent;
    int []size;

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

        if(size[uu]>size[vv]){
            parent[vv]=uu;
            size[uu]+=size[vv];
        }
        else{
            parent[uu]=vv;
            size[vv]+=size[uu];
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i,j);
                }
            }
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(i==parent[i]){
                component++;
            }
        }
        return n-component;
    }
}
