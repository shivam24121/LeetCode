class Solution {

    int[][] dp;
    int n;

    public boolean checkValidString(String s) {
        
        n=s.length();

        dp=new int[n+1][101];

        for(int[] a:dp){
            Arrays.fill(a,-1);
        }

        return solve(0,0,s);
    }
    public boolean solve(int idx,int val,String s){

        if(val<0){
            return false;
        }

        if(idx==s.length()){
            return val==0; 
        }
        // System.out.println(idx+" "+val);
        if(dp[idx][val]!=-1){
            return dp[idx][val]==1?true:false;
        }
        boolean res=false;

        if(s.charAt(idx)=='('){
            res=(res|solve(idx+1,val+1,s));
        }
        else if(s.charAt(idx)==')'){
            res=(res|solve(idx+1,val-1,s));
        }
        else{
        
            res=(res|solve(idx+1,val+1,s));

            res=(res|solve(idx+1,val-1,s));

            res=(res|solve(idx+1,val,s));
        }
        dp[idx][val]=res?1:0;
        return res;
    }
}
