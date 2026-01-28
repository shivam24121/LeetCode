class Solution {
    public int longestStrChain(String[] words) {

        int n=words.length;

        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int res=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(solve(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }
    public boolean solve(String a,String b){
        int i=0;
        int j=0;

        int n=a.length();
        int m=b.length();

        if(m!=n+1)return false;

        while(i<n && j<m){
            if(a.charAt(i)==b.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }
}
