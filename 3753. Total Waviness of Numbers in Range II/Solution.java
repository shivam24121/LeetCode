class Solution {
    public long totalWaviness(long num1, long num2) {
        return solve(num2)-solve(num1-1);
    }
    public long solve(long num){
        if(num<=100){
            return 0L;
        }
        String s=String.valueOf(num);
        int n=s.length();
        int[] digit=new int[n];
        for(int i=0;i<n;i++){
            digit[i]=s.charAt(i)-'0';
        }
        long[][][][][][] dp=new long[n][2][2][11][11][n];

        for(long[][][][][] a:dp){
            for(long[][][][] b:a){
                for(long[][][] c:b){
                    for(long[][] d:c){
                        for(long[] e:d){
                            Arrays.fill(e,-1);
                        }
                    }
                }
            }
        }
        return dfs(0,1,1,10,10,0,digit,dp);
    }
    public long dfs(int idx,int tight,int lz,int prev,int prev2,int sum,int[] digit,long[][][][][][] dp){

        if(idx==digit.length){
            return (long)sum;
        }
        if(dp[idx][tight][lz][prev][prev2][sum]!=-1){
            return dp[idx][tight][lz][prev][prev2][sum];
        }
        long res=0;
        int limit=(tight==1)?digit[idx]:9;

        for(int i=0;i<=limit;i++){

            int nextTight=(tight==1 &&  i==limit)?1:0;
            int nlz=(lz==1 && i==0)?1:0;
            int nextSum=sum;

            if(prev2!=10 && lz==0){
                if(prev>prev2 && prev>i){
                    nextSum++;
                }
                if(prev<prev2 && prev<i){
                    nextSum++;
                }
            }

            int nextPrev;
            int nextPrev2;

            if(nlz==1){
               nextPrev=10;
               nextPrev2=10;
            }
            else{
                nextPrev=i;
                nextPrev2=prev;
            }
            res+=dfs(idx+1,nextTight,nlz,nextPrev,nextPrev2,nextSum,digit,dp);
        }
        return dp[idx][tight][lz][prev][prev2][sum]=res;
    }
}
/*

state +
idx
tight
prev1
prev2
sum 
leading zeros


*/
