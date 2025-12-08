class Solution {
    public int countTriples(int n) {
        int res=0;
        for(int a=1;a<=n;a++){
            for(int b=a+1;b<=n;b++){
                int temp=(a*a)+(b*b);
                int sq=(int)Math.sqrt(temp);
                if((sq*sq)==temp && sq<=n){
                    res+=2;
                }
            }
        }
        return res;
    }
}
