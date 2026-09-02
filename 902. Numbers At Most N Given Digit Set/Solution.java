class Solution {
    int len;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        return solve(digits,n);
    }
    public int solve(String[] arr,int n){

        int mask=0;
        for(String i:arr){
            int temp=Integer.parseInt(i);
            mask=(mask|(1<<(temp)));
        }
        String s=String.valueOf(n);
        len=s.length();
        int[][][] dp=new int[len+1][2][2];
        
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return dfs(0,1,1,mask,s,dp);
    }
    public int dfs(int idx,int tight,int zero,int mask,String s,int[][][] dp){

        if(idx==len){
            return zero==1?0:1;
        }
        if(dp[idx][tight][zero]!=-1){
            return dp[idx][tight][zero];
        }
        int res=0;
        int limit=tight==1?s.charAt(idx)-'0':9;

        for(int i=0;i<=limit;i++){

            int newTight=(tight==1 && i==limit)?1:0;

            if(i==0 && zero==1){
                res=(res+dfs(idx+1,newTight,1,mask,s,dp));
            }
            else if((mask&(1<<i))==0){
                continue;
            }
            else{
                res=(res+dfs(idx+1,newTight,0,mask,s,dp));
            }
        }
        return dp[idx][tight][zero]=res;
    }
}

