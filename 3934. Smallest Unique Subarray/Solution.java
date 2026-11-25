import java.util.Arrays;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int[] sa = buildSuffixArray(nums);
        int[] lcp = buildLCP(nums, sa);

        int answer = n;

        for (int r = 0; r < n; r++) {
            int maxLcp = lcp[r];

            if (r + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[r + 1]);
            }

            int uniqueLength = maxLcp + 1;
            int suffixLength = n - sa[r];

            if (uniqueLength <= suffixLength) {
                answer = Math.min(answer, uniqueLength);
            }
        }

        return answer;
    }

    private int[] buildSuffixArray(int[] nums) {
        int n = nums.length;
        int m = n + 1;

        int[] s = new int[m];

        for (int i = 0; i < n; i++) {
            s[i] = nums[i] + 1;
        }

        s[n] = 0;

        int[] sa = new int[m];
        int[] rank = new int[m];
        int[] newRank = new int[m];
        int[] shifted = new int[m];

        int alphabet = Math.max(100002, m);
        int[] count = new int[alphabet];

        for (int value : s) {
            count[value]++;
        }

        for (int i = 1; i < alphabet; i++) {
            count[i] += count[i - 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            sa[--count[s[i]]] = i;
        }

        int classes = 1;
        rank[sa[0]] = 0;

        for (int i = 1; i < m; i++) {
            if (s[sa[i]] != s[sa[i - 1]]) {
                classes++;
            }

            rank[sa[i]] = classes - 1;
        }

        for (int len = 1; len < m; len <<= 1) {
            for (int i = 0; i < m; i++) {
                shifted[i] = sa[i] - len;

                if (shifted[i] < 0) {
                    shifted[i] += m;
                }
            }

            Arrays.fill(count, 0, classes, 0);

            for (int index : shifted) {
                count[rank[index]]++;
            }

            for (int i = 1; i < classes; i++) {
                count[i] += count[i - 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                int index = shifted[i];
                sa[--count[rank[index]]] = index;
            }

            int newClasses = 1;
            newRank[sa[0]] = 0;

            for (int i = 1; i < m; i++) {
                int current = sa[i];
                int previous = sa[i - 1];

                int currentFirst = rank[current];
                int previousFirst = rank[previous];

                int currentSecond = rank[(current + len) % m];
                int previousSecond = rank[(previous + len) % m];

                if (currentFirst != previousFirst ||
                    currentSecond != previousSecond) {
                    newClasses++;
                }

                newRank[current] = newClasses - 1;
            }

            int[] temp = rank;
            rank = newRank;
            newRank = temp;

            classes = newClasses;

            if (classes == m || len > m / 2) {
                break;
            }
        }

        int[] result = new int[n];
        int index = 0;

        for (int suffix : sa) {
            if (suffix != n) {
                result[index++] = suffix;
            }
        }

        return result;
    }

    private int[] buildLCP(int[] nums, int[] sa) {
        int n = nums.length;

        int[] position = new int[n];
        int[] lcp = new int[n];

        for (int i = 0; i < n; i++) {
            position[sa[i]] = i;
        }

        int h = 0;

        for (int i = 0; i < n; i++) {
            int r = position[i];

            if (r == 0) {
                h = 0;
                continue;
            }

            int j = sa[r - 1];

            while (i + h < n &&
                   j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) {
                h--;
            }
        }

        return lcp;
    }
}
