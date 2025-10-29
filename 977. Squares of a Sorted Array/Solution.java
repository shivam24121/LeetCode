class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int[] res=new int[n];
        int idx=0;

        for(int i:nums){
            pq.offer(Math.abs(i));
        }
        while(!pq.isEmpty()){
            int i=pq.poll();
            res[idx++]=i*i;
        }
        return res;
    }
}
