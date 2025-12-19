class Solution {

    int[] parent;
    int[] size;

    public void DSU(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int u){
        if(parent[u]!=u){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public void union(int u,int v){
        int uu=find(u);
        int vv=find(v);

        if(uu==vv)return;

        if(size[uu]>size[vv]){
            parent[vv]=uu;
            size[uu]+=size[vv];
        }
        else{
            parent[uu]=vv;
            size[vv]+=size[uu];
        }
    }
    public void reset(int u){
        parent[u]=u;
        size[u]=1;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        DSU(n);
        Arrays.sort(meetings,(a,b)->a[2]-b[2]);
        union(0,firstPerson);

        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            ArrayList<Integer>seen=new ArrayList<>();
            while(i<meetings.length && meetings[i][2]==time){
                int x=meetings[i][0];
                int y=meetings[i][1];
                union(x,y);
                seen.add(x);
                seen.add(y);
                i++;
            }
            for(int num:seen){
                if(find(num)!=find(0)){
                    reset(num);
                }
            }
            
        }
        List<Integer>res=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(find(j)==find(0)){
                res.add(j);
            }
        }
        return res;
    }
}
