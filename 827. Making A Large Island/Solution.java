class Solution {

    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};

    int[] parent;
    int[] size;

    public void dsu(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
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
            parent[v]=u;
            size[u]+=size[v];
        }
        else{
            parent[u]=v;
            size[v]+=size[u];
        }
    }
    public int largestIsland(int[][] grid) {

        int n=grid.length;
        int total=n*n;

        dsu(total);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    
                    int id1=i*n+j;

                    for(int k=0;k<4;k++){
                        int xx=i+dx[k];
                        int yy=j+dy[k];

                        if(xx>=0 && xx<n && yy>=0 && yy<n && grid[xx][yy]==1){
                            int id2=xx*n+yy;

                            union(id1,id2);
                        }
                    }
                }
            }
        }
        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)continue;

                int area=1;
                HashSet<Integer>set=new HashSet<>();

                for(int k=0;k<4;k++){
                    
                    int xx=i+dx[k];
                    int yy=j+dy[k];

                    if(xx>=0 && xx<n && yy>=0 && yy<n && grid[xx][yy]==1){
                        int id=xx*n+yy;
                        int root=find(id);

                        if(set.contains(root))continue;
                        area+=size[root];
                        set.add(root);
                    }
                }
                max=Math.max(max,area);
            }
        }
        return max==0?total:max;
    }
}
