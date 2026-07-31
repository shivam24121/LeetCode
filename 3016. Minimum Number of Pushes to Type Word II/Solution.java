class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Integer[] arr = new Integer[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = freq[i];
        }

        Arrays.sort(arr, (a, b) -> b - a);

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                break;
            }

            int pushes = i / 8 + 1;
            ans += arr[i] * pushes;
        }

        return ans;
    }
}
