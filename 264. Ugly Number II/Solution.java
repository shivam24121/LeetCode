class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;

        int i2,i3,i5;
        i2=i3=i5=1;
        
        for(int i=2;i<=n;i++){
            int one=dp[i2]*2;
            int two=dp[i3]*3;
            int three=dp[i5]*5;

            int min=Math.min(one,Math.min(two,three));
            dp[i]=min;

            if(one==min)i2++;
            if(two==min)i3++;
            if(three==min)i5++;
        }
        return dp[n];
    }
}
