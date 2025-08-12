class Solution {
    int[][] t=new int[301][301];
    int m=1000000007;
    public int numberOfWays(int n, int x) {
        for(int i=0;i<301;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(n,1,x);
    }
    public int solve(int n,int num,int x){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int curr=(int)Math.pow(num,x);
        if(curr>n){
            return 0;
        }

        if(t[n][num]!=-1){
            return t[n][num];
        }
        int take=solve(n-curr,num+1,x);
        int leave=solve(n,num+1,x);
        return t[n][num]=(take+leave)%m;
    }
}
