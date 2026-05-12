class Solution {
    public int findIntegers(int n) {
        return solve(n);
    }
    public int solve(int num){

        String s=Integer.toBinaryString(num);
        int n=s.length();

        int[] digit=new int[n];

        for(int i=0;i<n;i++){
            digit[i]=s.charAt(i)-'0';
        }
        int[][][] dp=new int[n][2][2];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return dfs(0,1,0,digit,dp);
    }
    public int dfs(int idx,int tight,int prev,int[] digit,int[][][] dp){

        if(idx==digit.length){
            return 1;
        }
        if(dp[idx][tight][prev]!=-1){
            return dp[idx][tight][prev];
        }
        int res=0;
        int limit=(tight==1)?digit[idx]:1;

        for(int i=0;i<=limit;i++){
            
            if(i==1 && prev==1){
                continue;
            }
            int nextTight=(tight==1 && i==limit)?1:0;
            int nextPrev=i;

            res+=dfs(idx+1,nextTight,nextPrev,digit,dp);
        }
        return dp[idx][tight][prev]=res;
    }
}
