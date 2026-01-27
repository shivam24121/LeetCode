class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,2*w});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currNode=curr[0];
            int currDist=curr[1];

            if(currDist>dist[currNode]){
                continue;
            }
            for(int[] neigh:adj.get(currNode)){
                int nextNode=neigh[0];
                int nextDist=neigh[1];

                if(nextDist+dist[currNode]<dist[nextNode]){
                    dist[nextNode]=nextDist+dist[currNode];
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE?-1:dist[n-1];
    }
}
