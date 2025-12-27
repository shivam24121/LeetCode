class Solution {
    public int mostBooked(int n, int[][] meet) {
        int[] count=new int[n];
        long[] finish=new long[n];
        Arrays.sort(meet,(a,b)->a[0]-b[0]);

        for(int[] e:meet){
            int start=e[0];
            int end=e[1];
            int duration=end-start;
            int empty=-1;

            for(int i=0;i<n;i++){
                if(finish[i]<=start){
                    empty=i;
                    break;
                }
            }
            if(empty!=-1){
                count[empty]++;
                finish[empty]=start+duration;
            }
            else{
                long minTime=finish[0];
                int minIdx=0;
                for(int i=1;i<n;i++){
                    if(finish[i]<minTime){
                        minTime=finish[i];
                        minIdx=i;
                    }
                }
                finish[minIdx]=finish[minIdx]+duration;
                count[minIdx]++;
            }
        }
        int res=0,max=0;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                res=i;
            }
        }
        return res;
    }
}
