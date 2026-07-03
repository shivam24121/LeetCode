class Solution {
    int n;
    public int findMaxPathScore(int[][] edges, boolean[] vis, long k) {
        
        n=vis.length;

        ArrayList<ArrayList<long[]>>adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int l=Integer.MAX_VALUE;
        int r=0;

        for(int[] e:edges){

            int u=e[0];
            int v=e[1];
            int w=e[2];

            if(!vis[u] || !vis[v]){
                continue;
            }
                
            adj.get(u).add(new long[]{v,w});
            l=Math.min(l,w);
            r=Math.max(r,w);
            
        }
        // for(ArrayList<long[]>x:adj){
        //     for(long[] y:x){
        //         for(long z:y){
        //             System.out.print(z+" ");
        //         }
        //         System.out.println();
        //     }
        // }

        int res=-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(mid,adj,k)){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public boolean valid(int mid,ArrayList<ArrayList<long[]>>adj,long k){

        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.offer(new long[]{0,0});

        
        while(!pq.isEmpty()){

            long[] curr=pq.poll();

            // System.out.println("yaha+ "+curr[0]+" "+curr[1]+" "+curr[2]);

            int currNode=(int)curr[0];
            long currK=curr[1];
            
            if(dist[currNode]<currK){
                continue;
            }
            if(currK>k)continue;

            if(currNode==n-1){
                return true;
            }
            for(long[] neigh:adj.get(currNode)){

                int nextNode=(int)neigh[0];
                long nextK=neigh[1];

                if(nextK<mid)continue;

                if(dist[currNode]+nextK<dist[nextNode]){
                    dist[nextNode]=dist[currNode]+nextK;
                    pq.offer(new long[]{nextNode,dist[nextNode]});
                }
            }
        }
        return false;
    }
}
