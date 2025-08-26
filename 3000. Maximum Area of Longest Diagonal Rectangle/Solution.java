class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int m=dimensions.length;
        int n=dimensions[0].length;
        int tempa=dimensions[0][0],tempb=dimensions[0][1];
        int diagonal=tempa*tempa+tempb*tempb;
        int area=tempa*tempb;
        for(int i=1;i<m;i++){
            int a=dimensions[i][0];
            int b=dimensions[i][1];
            int curdia=a*a+b*b;
            int curarea=a*b;
            
            if(curdia>diagonal || (curdia==diagonal && curarea>area)){
                tempa=a;
                tempb=b;
                diagonal=curdia;
                area=curarea;
            }
        }
        return tempa*tempb;
    }
}
