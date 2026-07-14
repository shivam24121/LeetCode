class Solution {

    int n;
    int[][][] dp;
    int mod=(int)1e9+7;

    public int subsequencePairCount(int[] nums) {
        
        n=nums.length;

        int max=0;

        for(int i:nums){
            max=Math.max(max,i);
        }

        dp=new int[n+1][max+1][max+1];

        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(0,0,0,nums);
    }
    public int solve(int idx,int g1,int g2,int[] nums){

        if(idx==n){
            return (g1==g2 && g1!=0)?1:0;
        }
        // System.out.println(idx+" "+g1+" "+g2);
        if(dp[idx][g1][g2]!=-1){
            return dp[idx][g1][g2];
        }

        int ways=0;

        ways=(ways+solve(idx+1,g1,g2,nums))%mod;

        ways=(ways+solve(idx+1,gcd(g1,nums[idx]),g2,nums))%mod;

        ways=(ways+solve(idx+1,g1,gcd(g2,nums[idx]),nums))%mod;

        return dp[idx][g1][g2]=ways;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
