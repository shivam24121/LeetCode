class Solution {

    int[] dp;
    int n;

    public int minCut(String s) {
        
        n=s.length();
        dp=new int[n];

        Arrays.fill(dp,-1);

        return solve(0,s)-1;
    }
    public boolean palindrome(String s,int l,int r){

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int solve(int idx,String s){

        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=Integer.MAX_VALUE;

        for(int i=idx;i<s.length();i++){
            if(palindrome(s,idx,i)){
                ans=Math.min(ans,1+solve(i+1,s));
            }
        }
        return dp[idx]=ans;
    }
}
