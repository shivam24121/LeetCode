class Solution {
    static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int[][] dp = new int[N + 1][2 * k + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 2 * k); j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }

        return dp[N][2 * k];
    }
}
