class Solution {
    public int minJumps(int[] nums) {

        int n=nums.length;

        Map<Integer,ArrayList<Integer>>map=new HashMap<>();
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(isPrime(nums[i])){
                map.putIfAbsent(nums[i],new ArrayList<>());
            }
        }
        for(int i=0;i<n;i++){
            ArrayList<Integer>fact=factor(nums[i]);
            for(int ele:fact){
                if(map.containsKey(ele)){
                    map.get(ele).add(i);
                }
            }
        }
        Queue<Integer>q=new ArrayDeque<>();
        int level=0;
        q.offer(0);
        vis[0]=true;

        while(!q.isEmpty()){

            int nn=q.size();

            for(int i=0;i<nn;i++){

                int curr=q.poll();

                if(curr==n-1){
                    return level;
                }
                if(curr+1<n && vis[curr+1]==false){
                    q.offer(curr+1);
                    vis[curr+1]=true;
                }
                if(curr-1>=0 && vis[curr-1]==false){
                    q.offer(curr-1);
                    vis[curr-1]=true;
                }
                if(map.containsKey(nums[curr])){
                    for(int neigh:map.get(nums[curr])){
                        if(vis[neigh]==false){
                            q.offer(neigh);
                            vis[neigh]=true;
                        }
                    }
                    map.remove(nums[curr]);
                }
            }
            level++;
        }
        return n-1;
                                                
    }
    public ArrayList<Integer>factor(int n){

        ArrayList<Integer>list=new ArrayList<>();

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
            while(n%i==0){
                n/=i;
            }
        }
        if(n>1){
            list.add(n);
        }
        return list;
    }
    public boolean isPrime(int n){

        if(n<2){
            return false;
        }

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}
