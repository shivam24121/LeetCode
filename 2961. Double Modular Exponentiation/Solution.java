class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n=variables.length;
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=variables[i][0];
            int b=variables[i][1];
            int c=variables[i][2];
            int m=variables[i][3];
            int firstMod = pow(a, b, 10); 
            int finalMod = pow(firstMod,c,m);
            if(finalMod==target){
                index.add(i);
            }
        }
        return index;
    }
    
    private int pow(long base, int exp, int mod) {
        long result =1;
        base%=mod;
        while(exp > 0) {
            if((exp & 1)==1){
                result= (result*base) % mod;
            }
            base= (base*base) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
