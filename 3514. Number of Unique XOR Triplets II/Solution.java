class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        for (int a : nums)
            for (int b : nums)
                two[a ^ b] = true;

        for (int x = 0; x < 2048; x++) {
            if (!two[x]) continue;

            for (int a : nums)
                three[x ^ a] = true;
        }

        int ans = 0;

        for (boolean x : three)
            if (x) ans++;

        return ans;
    }
}
