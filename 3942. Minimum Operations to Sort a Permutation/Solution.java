class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos + i) % n] != i) {
                ok = false;
                break;
            }
        }
        if (ok) ans = Math.min(ans, pos);

        ok = true;
        for (int i = 0; i < n; i++) {
            int idx = (pos - i + n) % n;
            if (nums[idx] != i) {
                ok = false;
                break;
            }
        }
        if (ok) ans = Math.min(ans, pos + 2);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
