class Solution {

    public int numDupDigitsAtMostN(int n) {
        
        return solve(n);
    }
    public int solve(int n){

        String s=String.valueOf(n);
        int len=s.length();

        int[] digit=new int[len];

        for(int i=0;i<len;i++){
            digit[i]=s.charAt(i)-'0';
        }
        int[][][][][] dp=new int[len][2][1024][2][2];

        for(int[][][][] a:dp){
            for(int[][][] b:a){
                for(int[][] c:b){
                    for(int[] d:c){
                        Arrays.fill(d,-1);
                    }
                }
            }
        }
        return dfs(0,1,0,0,0,digit,dp);
    }
    public int dfs(int idx,int tight,int mask,int ct,int start,int[] digit,int[][][][][] dp){

        if(idx==digit.length){
            return (start==1 && ct>0)?1:0;
        }
        if(dp[idx][tight][mask][ct][start]!=-1){
            return dp[idx][tight][mask][ct][start];
        }
        int res=0;

        int limit=tight==1?digit[idx]:9;

        for(int i=0;i<=limit;i++){

            int nextTight=(tight==1 && i==limit)?1:0;
            int nextStart=(start==0 && i==0)?0:1;
            int nextCt=ct;
            int nextMask=mask;

            if(nextStart==1){
                if(((1<<i)&mask)!=0){
                    nextCt=1;
                }
                nextMask|=(1<<i);
            }

            res+=dfs(idx+1,nextTight,nextMask,nextCt,nextStart,digit,dp);
        }
        return dp[idx][tight][mask][ct][start]=res;
    }
}
