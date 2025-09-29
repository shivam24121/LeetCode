class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<score.length;i++){
            pq.offer(new int[]{score[i],i});
        } 
        String[] res=new String[score.length];
        int rank=1;
        
        while(!pq.isEmpty()){
            int[] top=pq.poll();
            if(rank==1){
                res[top[1]]="Gold Medal";
            }
            else if(rank==2){
                res[top[1]]="Silver Medal";
            }
            else if(rank==3){
                res[top[1]]="Bronze Medal";
            }
            else{
                res[top[1]]=String.valueOf(rank);
            }
            rank++;
        }
        return res;
    }
}
