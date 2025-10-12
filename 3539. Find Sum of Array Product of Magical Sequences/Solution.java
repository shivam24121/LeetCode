import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007, MAX = 31;
    static final long[] FACT = new long[MAX], INV_FACT = new long[MAX];
    static {
        FACT[0] = 1;
        for (int i = 1; i < MAX; i++) FACT[i] = FACT[i - 1] * i % MOD;
        INV_FACT[MAX - 1] = pow(FACT[MAX - 1], MOD - 2);
        for (int i = MAX - 1; i > 0; i--) INV_FACT[i - 1] = INV_FACT[i] * i % MOD;
    }
    static long pow(long x, int n) {
        long r = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD) if ((n & 1) == 1) r = r * x % MOD;
        return r;
    }
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] pows = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++) pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD);
        }
        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo) for (int[][] b : a) for (int[] c : b) Arrays.fill(c, -1);
        return (int) (dfs(0, m, 0, k, pows, memo) * FACT[m] % MOD);
    }
    long dfs(int i, int mL, int c, int kL, int[][] p, int[][][][] memo) {
        int o = Integer.bitCount(c);
        if (o + mL < kL) return 0;
        if (i == p.length) return (mL == 0 && o == kL) ? 1 : 0;
        if (memo[i][mL][c][kL] != -1) return memo[i][mL][c][kL];
        long r = 0;
        for (int j = 0; j <= mL; j++) {
            int b = (c + j) & 1;
            if (b <= kL) r = (r + dfs(i + 1, mL - j, (c + j) >> 1, kL - b, p, memo)
            * p[i][j] % MOD * INV_FACT[j]) % MOD;
        }
        return memo[i][mL][c][kL] = (int) r;
    }
}
