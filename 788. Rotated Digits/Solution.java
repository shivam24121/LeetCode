class Solution {

    int[][][] dp;
    int len;

    public int rotatedDigits(int n) {
        return solve(n);
    }
    public int solve(int n){

        String s=String.valueOf(n);
        len=s.length();

        int[] digit=new int[len];

        for(int i=0;i<len;i++){
            digit[i]=s.charAt(i)-'0';
        }
        dp=new int[len+1][2][2];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return ddp(0,1,0,digit);
    }
    public int ddp(int idx,int tight,int ct,int[] digit){

        // System.out.println(idx+" "+tight+" "+ct);

        if(idx==len){
            return ct>0?1:0;
        }
        if(dp[idx][tight][ct]!=-1){
            return dp[idx][tight][ct];
        }
        int limit=tight==1?digit[idx]:9;

        int res=0;

        for(int i=0;i<=limit;i++){

            if(i==3 || i==4 || i==7)continue;
          
            int nextTight=(tight==1 && i==digit[idx])?1:0;
            int nextCt=Math.max(ct,(helper(i)?1:0));

            res+=ddp(idx+1,nextTight,nextCt,digit);
        }
        return dp[idx][tight][ct]=res;
    }
    boolean helper(int n){
        return n==2 || n==5 || n==6 || n==9;
    }
}
