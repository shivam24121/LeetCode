class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int n=graph.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] inorder=new int[n];

        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                inorder[i]++;
            }
        }
        

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:adj.get(curr)){
                inorder[neigh]--;

                if(inorder[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(inorder[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
