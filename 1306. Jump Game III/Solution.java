class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n=arr.length;

        Queue<Integer>q=new ArrayDeque<>();
        Set<Integer>set=new HashSet<>();

        q.offer(start);
        set.add(start);

        while(!q.isEmpty()){
            int curr=q.poll();
            int val=arr[curr];

            if(val==0){
                return true;
            }
            if(curr+val<n && !set.contains(curr+val)){
                q.offer(curr+val);
                set.add(curr+val);
            }
            if(curr-val>=0 && !set.contains(curr-val)){
                q.offer(curr-val);
                set.add(curr-val);
            }
        }
        return false;
    }
}
