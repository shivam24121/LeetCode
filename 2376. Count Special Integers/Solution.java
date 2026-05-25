class Solution {
    public int countSpecialNumbers(int n) {
        return solve(n)-solve(0);
    }
    public int solve(int n){

        String s=String.valueOf(n);
        int[] digit=new int[s.length()];

        for(int i=0;i<s.length();i++){
            digit[i]=s.charAt(i)-'0';
        }

        int[][][][] dp=new int[s.length()][2][2][1024];

        for(int[][][] a:dp){
            for(int[][] b:a){
                for(int[] c:b){
                    Arrays.fill(c,-1);
                }
            }
        }
        return dfs(0,1,0,0,digit,dp);
    }
    public int dfs(int idx,int tight,int started,int mask,int[] digit,int[][][][] dp){

        if(idx==digit.length){
            return started==0?0:1;
        }
        if(dp[idx][tight][started][mask]!=-1){
            return dp[idx][tight][started][mask];
        }
        int res=0;
        int limit=tight==1?digit[idx]:9;

        for(int i=0;i<=limit;i++){

            int nextTight=(tight==1 && i==limit)?1:0;

            if(i==0 && started==0){
                res+=dfs(idx+1,nextTight,0,mask,digit,dp);
            }
            else{

                if(((1<<i)&mask)!=0)continue;
                int nextMask=mask|(1<<i);
                res+=dfs(idx+1,nextTight,1,nextMask,digit,dp);

            }
        }
        return dp[idx][tight][started][mask]=res;
    }
}
