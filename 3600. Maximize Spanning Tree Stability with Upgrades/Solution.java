class Solution {

    int[] parent;
    int[] size;

    public void dsu(int n){

        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int u){

        if(u!=parent[u]){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public void union(int u,int v){

        u=find(u);
        v=find(v);

        if(u==v){
            return;
        }

        if(size[u]>size[v]){
            size[u]+=size[v];
            parent[v]=u;
        }

        else{
            size[v]+=size[u];
            parent[u]=v;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        
        dsu(n);

        for(int[] e:edges){

            int u=e[0];
            int v=e[1];
            int s=e[2];
            int m=e[3];

            if(m==1){
                if(find(u)==find(v)){
                    return -1;
                }
                union(u,v);
            }
        }
        int ans=-1;
        int l=1,r=2*(int)1e5;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(n,edges,k,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public boolean valid(int n,int[][] edges,int k,int mid){
        
        dsu(n);
        ArrayList<int[]>temp=new ArrayList<>();

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int s=e[2];
            int m=e[3];

            if(m==1){
                if(s<mid){
                    return false;
                }
                union(u,v);
            }
            else{
                if(find(u)!=find(v)){
                    if(s>=mid){
                        union(u,v);
                    }
                    else if(2*s>=mid){
                        temp.add(new int[]{u,v});
                    }
                }
            }
        }
        for(int[] nums:temp){

            int u=nums[0];
            int v=nums[1];

            if(find(u)==find(v))continue;

            if(k<=0)return false;

            union(u,v);

            k--;
        }
        int root=find(0);
        for(int i=1;i<n;i++){
            if(find(i)!=root){
                return false;
            }
        }
        return true;
    }
}
