class Solution {

    // int ans=0;

    public int countPaths(int n, int[][] roads) {

        int mod=(int)1e9+7;

        ArrayList<ArrayList<long[]>>adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:roads){
            int u=e[0];
            int v=e[1];
            long w=e[2];
            adj.get(u).add(new long[]{v,w});
            adj.get(v).add(new long[]{u,w});
        }
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.offer(new long[]{0,0});
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        long[] ways=new long[n];
        ways[0]=1;

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            int currNode=(int)curr[0];
            long currDist=curr[1];

            if(dist[currNode]<currDist)continue;

            for(long[] neigh:adj.get(currNode)){
                int nextNode=(int)neigh[0];
                long nextDist=neigh[1];

                if(dist[currNode]+nextDist<dist[nextNode]){
                    dist[nextNode]=dist[currNode]+nextDist;
                    pq.offer(new long[]{nextNode,dist[nextNode]});
                    ways[nextNode]=(ways[currNode])%mod;
                }
                else if(dist[currNode]+nextDist==dist[nextNode]){
                    ways[nextNode]=(ways[currNode]+ways[nextNode])%mod;
                    
                }
            }
        }

        return (int)(ways[n-1]+mod)%mod;
    }
}
