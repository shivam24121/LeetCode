class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer>pq=new PriorityQueue(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);

        int ct=0;
        while(true){
            int top=pq.poll();
            int second=pq.poll();

            if(second==0){
            break;
            }
            ct++;
            pq.add(top-1);
            pq.add(second-1);
        }
        return ct;
    }
}
