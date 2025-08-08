class Solution {
    private Double[][] check;
    private double solve(int a,int b){
        if(a<=0 && b<=0)return 0.5;
        if(a<=0 )return 1.0;
        if(b<=0)return 0.0;
        if(check[a][b]!=null)return check[a][b];
        double res=0;
        res+=0.25*solve(a-100,b);
        res+=0.25*solve(a-75,b-25);
        res+=0.25*solve(a-50,b-50);
        res+=0.25*solve(a-25,b-75);
        return check[a][b]=res;
    }
    public double soupServings(int n) {
    if(n>4800)return 1.0;
    check=new Double[n+1][n+1];   
    return solve(n,n);   
    }
}
