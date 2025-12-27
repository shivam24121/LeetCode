class Solution {
    int res=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        boolean[] inRecursion=new boolean[n];
        int[] count=new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,edges,visited,inRecursion,count);
            }
        }
        return res;
    }
    public void dfs(int u,int[] edges,boolean[] visited,boolean[] inRec,int[] count){
        if(u!=-1){

            visited[u]=true;
            inRec[u]=true;

            int v=edges[u];
            if(v!=-1 && !visited[v]){
                count[v]=count[u]+1;
                dfs(v,edges,visited,inRec,count);
            }
            else if(v!=-1 && inRec[v]){
                res=Math.max(res,count[u]-count[v]+1);
            }
            inRec[u]=false;
        }
    }
}
