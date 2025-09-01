class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            double cur=(double)classes[i][0]/classes[i][1];
            double upd=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double delta=upd-cur;
            pq.offer(new double[]{delta,i});
        }
        while(extraStudents-->0){
            double[] temp=pq.poll();
            int idx=(int)temp[1];

            classes[idx][0]++;
            classes[idx][1]++;

            double cur=(double)classes[idx][0]/classes[idx][1];
            double upd=(double)(classes[idx][0]+1)/(classes[idx][1]+1);
            double delta=upd-cur;
            pq.offer(new double[]{delta,idx});

        }
        double res=0;
        for(int i=0;i<n;i++){
            res+=(double)classes[i][0]/classes[i][1];
        }
        return res/n;
    }
}
