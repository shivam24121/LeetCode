class Solution {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double max=0.0;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){

                    double x1=points[i][0];
                    double y1=points[i][1];

                    double x2=points[j][0];
                    double y2=points[j][1];

                    double x3=points[k][0];
                    double y3=points[k][1];

                    double a=Math.hypot(x2-x1,y2-y1);
                    double b=Math.hypot(x2-x3,y2-y3);
                    double c=Math.hypot(x3-x1,y3-y1);

                    double s=(a+b+c)*0.5;
                    double temp=(s*(s-a)*(s-b)*(s-c));
                    if(temp<0)temp=0;
                    double area=Math.sqrt(temp);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
}
