class Solution {
    public int countOperations(int a, int b) {
        int step=0;

        while(a!=0 && b!=0){
            if(a>=b){
                a-=b;
            }
            else{
                b-=a;
            }
            step++;
        }
        return step;
    }
}
