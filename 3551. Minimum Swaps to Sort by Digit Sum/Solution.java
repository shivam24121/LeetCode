
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> {
            int s1 = digitSum(x[0]), s2 = digitSum(y[0]);
            if (s1 != s2) return s1 - s2;
            return x[0] - y[0];
        });

        boolean[] vis = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || a[i][1] == i) continue;

            int j = i, len = 0;

            while (!vis[j]) {
                vis[j] = true;
                j = a[j][1];
                len++;
            }

            swaps += len - 1;
        }

        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
