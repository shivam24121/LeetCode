class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int a : nums) sum += a;

        int target = sum - x;
        if (target < 0) return -1;
        if (target == 0) return n;

        int l = 0, curr = 0, maxLen = -1;

        for (int r = 0; r < n; r++) {
            curr += nums[r];

            while (curr > target) {
                curr -= nums[l++];
            }

            if (curr == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}
