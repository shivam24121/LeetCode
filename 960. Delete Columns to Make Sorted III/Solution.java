class Solution {
    public int minDeletionSize(String[] s) {
        int row=s.length;
        int col=s[0].length();

        int[] dp=new int[col];
        Arrays.fill(dp,1);

        int LIS=1;

        for(int i=0;i<col;i++){
            for(int j=0;j<i;j++){
                boolean fl=true;
                for(int k=0;k<row;k++){
                    if(s[k].charAt(j)>s[k].charAt(i)){
                        fl=false;
                    }
                }
                if(fl){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            LIS=Math.max(LIS,dp[i]);
        }
        return col-LIS;
    }
}
