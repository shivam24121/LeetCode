class Solution {

    int[][][] dp;

    public int countDigitOne(int n) {
        
        return solve(n);
    }
    public int solve(int n){
        
        String s=String.valueOf(n);
        int len=s.length();
        // System.out.println(len);

        int[] digit=new int[len];

        for(int i=0;i<len;i++){
            // System.out.println(s.charAt(i)-'0');
            digit[i]=s.charAt(i)-'0';
        }
        dp=new int[len+1][2][len+1];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return dfs(0,1,0,digit);
    }
    public int dfs(int idx,int tight,int ct,int[] digit){

        if(idx==digit.length){
            return ct;
        }
        if(dp[idx][tight][ct]!=-1){
            return dp[idx][tight][ct];
        }
        int res=0;
        int limit=tight==1?digit[idx]:9;

        for(int i=0;i<=limit;i++){

            int nextCt=ct+(i==1?1:0);
            int nextTight=(tight==1 && i==limit)?1:0;

            res+=dfs(idx+1,nextTight,nextCt,digit);
        }
        return dp[idx][tight][ct]=res;
    }
}
