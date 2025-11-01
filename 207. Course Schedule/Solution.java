class Solution {
    public boolean canFinish(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] inorder=new int[n];
        int ct=0;

        for(int[] e:edge){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
            inorder[u]++;
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0){
                ct++;
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:adj.get(curr)){
                inorder[neigh]--;

                if(inorder[neigh]==0){
                    ct++;
                    q.offer(neigh);
                }
            }
        }
        return ct==n;
    }
}
