class Solution {
    public double separateSquares(int[][] squares) {
        double ans=0,total=0;
        double min=Double.MAX_VALUE,max=Double.MIN_VALUE;
        for(int[] sq:squares){
            double len=sq[2];
            total+=len*len;
            min=Math.min(min,sq[1]);
            max=Math.max(max,sq[1]+sq[2]);
        }
        double target=total/2;

        double l=min,r=max;
        while(l<r){
            if(r-l<Math.pow(10,-5)){
                break;
            }
            double mid=(l+r)/2;
            if(area(mid,squares)<target){
                l=mid;
            }
            else{
                ans=mid;
                r=mid;
            }
        }
        return ans;
    }
    public double area(double mid,int[][] sq){
        double area=0;
        for(int[] s:sq){
            double y=s[1];
            double len=s[2];
            if(mid>=y+len){
                area+=len*len;
            }
            else if((mid>y) && (mid<y+len)){
                area+=len*(mid-y);
            }
        }
        return area;
    }
}
