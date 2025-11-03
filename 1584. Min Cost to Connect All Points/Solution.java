class Solution {
    static class Pair{
        int n;
        int d;
        Pair(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        int n=points.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int w=Math.abs(x2-x1)+Math.abs(y2-y1);
                adj.get(i).add(new Pair(j,w));
                adj.get(j).add(new Pair(i,w));
            }
        }

        int sum=0;
        boolean[] visited=new boolean[n];

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.d,b.d));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currNode=curr.n;
            int currDist=curr.d;

            if(visited[currNode])continue;
            visited[currNode]=true;
            sum+=currDist;

            for(Pair neigh:adj.get(currNode)){
                int nextNode=neigh.n;
                int nextDist=neigh.d;

                if(!visited[nextNode]){
                    pq.offer(new Pair(nextNode,nextDist));
                }
            }
        }
        return sum;
    }
}
