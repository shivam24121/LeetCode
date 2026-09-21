class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int x : nums) {
            long[] ndp = new long[k];

            ndp[x % k]++;

            for (int r = 0; r < k; r++) {
                ndp[(r * (x % k)) % k] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                ans[r] += ndp[r];
            }

            dp = ndp;
        }

        return ans;
    }
}
