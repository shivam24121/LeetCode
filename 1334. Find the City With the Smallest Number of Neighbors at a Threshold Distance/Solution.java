class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] adj=new int[n][n];
        int inf=(int)1e8;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    adj[i][j]=0;
                }
                else{
                    adj[i][j]=inf;
                }
            }
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj[u][v]=Math.min(adj[u][v],w);
            adj[v][u]=Math.min(adj[v][u],w);
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][via]!=inf && adj[via][j]!=inf){
                        adj[i][j]=Math.min(adj[i][j],adj[i][via]+adj[via][j]);
                    }
                }
            }
        }
        int res=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<n;i++){
            int ct=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=threshold)ct++;
            }
            if(ct<=res){
                res=ct;
                idx=i;
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(adj[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return idx;
    }
}
