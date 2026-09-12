class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int n;
    int[] next;
    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr[i].r);
        }

        dp = new Result[n + 1][5];

        return solve(0, 4).indices;
    }

    private Result solve(int i, int k) {
        if (i == n || k == 0)
            return new Result(0, new int[0]);

        if (dp[i][k] != null)
            return dp[i][k];

        Result skip = solve(i + 1, k);

        Result after = solve(next[i], k - 1);
        int[] takeIndices = insert(arr[i].idx, after.indices);
        Result take = new Result(arr[i].w + after.score, takeIndices);

        return dp[i][k] = better(skip, take);
    }

    private int findNext(int r) {
        int lo = 0, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid].l > r)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private int[] insert(int idx, int[] a) {
        int[] res = new int[a.length + 1];
        int p = 0;

        while (p < a.length && a[p] < idx) {
            res[p] = a[p];
            p++;
        }

        res[p] = idx;

        while (p < a.length) {
            res[p + 1] = a[p];
            p++;
        }

        return res;
    }

    private Result better(Result a, Result b) {
        if (a.score != b.score)
            return a.score > b.score ? a : b;

        return compare(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compare(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i])
                return Integer.compare(a[i], b[i]);
        }

        return Integer.compare(a.length, b.length);
    }
}
