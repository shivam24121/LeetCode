class Solution {
    public int minJumps(int[] arr) {
        
        int n=arr.length;
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();

        for(int i=0;i<n;i++){
            int val=arr[i];
            map.putIfAbsent(val,new ArrayList<>());
            map.get(val).add(i);
        }
        int ct=0;

        Queue<Integer>q=new ArrayDeque<>();
        Set<Integer>set=new HashSet<>();

        q.offer(0);
        set.add(0);

        while(!q.isEmpty()){

            int size=q.size();
            for(int i=0;i<size;i++){
                
                int curr=q.poll();

                if(curr==n-1){
                    return ct;
                }
                if(curr+1<n && !set.contains(curr+1)){
                    q.offer(curr+1);
                    set.add(curr+1);
                }
                if(curr-1>=0 && !set.contains(curr-1)){
                    q.offer(curr-1);
                    set.add(curr-1);
                }
                if(map.containsKey(arr[curr])){
                    for(int neigh:map.get(arr[curr])){
                        if(curr==neigh)continue;

                        if(!set.contains(neigh)){
                            q.offer(neigh);
                            set.add(neigh);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            ct++;
        }
        return n-1;
    }
}
