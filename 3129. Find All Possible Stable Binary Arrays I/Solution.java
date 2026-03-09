class Solution {

    int[][][] dp=new int[201][201][2];
    int mod=(int)1e9+7;

    public int numberOfStableArrays(int zero, int one, int limit) {
        
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }

        int Z=solve(zero,one,false,limit);
        int O=solve(zero,one,true,limit);

        return (Z+O)%mod;
    }
    public int solve(int zero,int one,boolean ek,int limit){

        if(zero==0 && one==0){
            return 1;
        }
        int k=ek?1:0;

        if(dp[zero][one][k]!=-1)return dp[zero][one][k];

        int res=0;

        if(ek){
            for(int i=1;i<=Math.min(limit,zero);i++){
                res=(res+solve(zero-i,one,false,limit))%mod;
            }
        }
        else{
            for(int i=1;i<=Math.min(limit,one);i++){
                res=(res+solve(zero,one-i,true,limit))%mod;
            }
        }
        return dp[zero][one][k]=res%mod;
    }
}
