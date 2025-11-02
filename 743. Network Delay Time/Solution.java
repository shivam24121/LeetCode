class Solution {
    static class Pair{
        int node;
        int distance;
        Pair(int n,int d){
            this.node=n;
            this.distance=d;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:times){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        boolean[] visited=new boolean[n+1];

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currNode=curr.node;
            int currDist=curr.distance;

            if(currDist>dist[currNode])continue;
            if(visited[currNode])continue;
            visited[currNode]=true;

            for(Pair neigh:adj.get(currNode)){
                int nextNode=neigh.node;
                int nextDist=neigh.distance;

                if(dist[currNode]+nextDist<dist[nextNode]){
                    dist[nextNode]=dist[currNode]+nextDist;
                    pq.offer(new Pair(nextNode,dist[nextNode]));
                }
            }
        }
        int res=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            res=Math.max(res,dist[i]);
        }
        return res;
    }
}
