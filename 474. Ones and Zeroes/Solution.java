class Solution {

    Integer[][][] dp;

    public int findMaxForm(String[] arr, int m, int n) {
        int len=arr.length;
        dp=new Integer[len+1][m+1][n+1];

        return solve(0,arr,m,n);
    }
    public int solve(int idx,String[] arr,int m,int n){
        if(idx>=arr.length)return 0;

        if(dp[idx][m][n]!=null)return dp[idx][m][n];

        int take=0;

        int currLenght=arr[idx].length();
        int zero=ctZero(arr[idx]);
        int one=currLenght-zero;

        if(m>=zero && n>=one){
            take=1+solve(idx+1,arr,m-zero,n-one);
        }

        int skip=solve(idx+1,arr,m,n);

        return dp[idx][m][n]=Math.max(take,skip);


    }
    public int ctZero(String s){
        int ct=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')ct++;
        }
        return ct;
    }
}
