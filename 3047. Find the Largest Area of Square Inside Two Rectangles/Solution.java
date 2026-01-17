class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        int n=bl.length;
        long max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int left=Math.max(bl[i][0],bl[j][0]);
                int bottom=Math.max(bl[i][1],bl[j][1]);
                int right=Math.min(tr[i][0],tr[j][0]);
                int top=Math.min(tr[i][1],tr[j][1]);

                if(left<right && top>bottom){
                    int h=top-bottom;
                    int w=right-left;
                    int side=Math.min(h,w);
                    max=Math.max(max,1l*side*side);
                }
            }
        }
        return max;
    }
}
