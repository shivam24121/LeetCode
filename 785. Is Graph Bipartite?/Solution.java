class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(graph,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int[] color,int node){
        color[node]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:graph[curr]){
                if(color[curr]==color[neigh])return false;
                else if(color[neigh]==-1){
                    int cc=1-color[curr];
                    color[neigh]=cc;
                    q.offer(neigh);
                }
            }
        }
        return true;
    }
}
