class Solution {

    ArrayList<ArrayList<int[]>>adj;
    List<Integer> res;
    int[] rev;
    
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(new int[]{v,i});
            adj.get(v).add(new int[]{u,i});
        }
        rev=new int[n];

        for(int i=0;i<start.length();i++){
            char a=start.charAt(i);
            char b=target.charAt(i);

            rev[i]=a==b?0:1;
        }
        res=new ArrayList<>();
        
        int ans=dfs(0,-1);
        if(ans==1){
            List<Integer>temp=new ArrayList<>();
            temp.add(-1);
            return temp;
        }
        Collections.sort(res);
        return res;
    }
    public int dfs(int u,int parent){
        int need=rev[u];

        for(int[] neigh:adj.get(u)){
            int v=neigh[0];
            int idx=neigh[1];
            
            if(v==parent){
                continue;
            }
            int next=dfs(v,u);
            if(next==1){
                res.add(idx);
                need^=1;
            }
        }
        return need;
    }
}
