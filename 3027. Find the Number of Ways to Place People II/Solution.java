class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            else return a[0]-b[0];
        });
        int res=0;

        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1=points[i][1];

            int flagY=Integer.MIN_VALUE;

            for(int j=i+1;j<n;j++){
                int x2=points[j][0];
                int y2=points[j][1];

                if(y2>y1)continue;

                if(y2>flagY){
                    res++;
                    flagY=y2;
                }
            }
        }
        return res;
    }
}
