class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.merge((long) x, 1, Integer::sum);
        }

        int ans = 1;

        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, cnt % 2 == 0 ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {

            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (cur > (long) Math.sqrt(Long.MAX_VALUE))
                    break;

                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) == 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
