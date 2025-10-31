class Solution {
    int idx=0;
    int ct=0;
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] res=new int[n];
        int[] inorder=new int[n];

        for(int[] e: prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
            inorder[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0){
                q.offer(i);
                ct++;
                res[idx++]=i;
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:adj.get(curr)){
                inorder[neigh]--;

                if(inorder[neigh]==0){
                    q.offer(neigh);
                    ct++;
                    res[idx++]=neigh;
                }
            }
        }
        
        return ct==n?res:new int[]{};
    }
}
