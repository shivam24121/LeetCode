class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n=intervals.length;
        int ct=0;
        int max1=-1,max2=-1;

        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });

        for(int i=0;i<n;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];

            boolean one=(max1>=s);
            boolean two=(max2>=s);

            if(one && two)continue;
            else if(one || two){
                ct++;
                max2=one?max1:max2;
                max1=e;
            }
            else{
                ct+=2;
                max1=e;
                max2=e-1;
            }
        }
        return ct;
    }
}
