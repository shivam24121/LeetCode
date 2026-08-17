class Solution {
    int[][] dp;

    public int stoneGameV(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++)
            java.util.Arrays.fill(dp[i], -1);

        return solve(arr, 0, n - 1);
    }

    public int solve(int[] arr, int l, int r) {
        if (l >= r)
            return 0;

        if (dp[l][r] != -1)
            return dp[l][r];

        int total = 0;

        for (int i = l; i <= r; i++)
            total += arr[i];

        int leftSum = 0;
        int ans = 0;

        for (int i = l; i < r; i++) {
            leftSum += arr[i];
            int rightSum = total - leftSum;

            if (leftSum < rightSum) {
                ans = Math.max(ans,
                        leftSum + solve(arr, l, i));
            } 
            else if (leftSum > rightSum) {
                ans = Math.max(ans,
                        rightSum + solve(arr, i + 1, r));
            } 
            else {
                ans = Math.max(ans,
                        Math.max(
                            leftSum + solve(arr, l, i),
                            rightSum + solve(arr, i + 1, r)
                        ));
            }
        }

        return dp[l][r] = ans;
    }
}
