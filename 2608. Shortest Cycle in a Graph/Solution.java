class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int res=Integer.MAX_VALUE;

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist,-1);
            dist[i]=0;
            Queue<Integer>q=new LinkedList<>();
            q.offer(i);

            while(!q.isEmpty()){
                int curr=q.poll();
                for(int neigh:adj.get(curr)){
                    if(dist[neigh]==-1){
                        dist[neigh]=dist[curr]+1;
                        q.offer(neigh);
                    }
                    else if(dist[neigh]>=dist[curr]){
                        res=Math.min(res,dist[neigh]+dist[curr]+1);
                    }
                    
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
