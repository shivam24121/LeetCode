
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int[] count = new int[k];
        int max = 0;

        for (int i = 0; i < arrival.length; i++) {

            while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[0]);
            }

            if (available.isEmpty()) continue;

            int start = i % k;

            Integer server = available.ceiling(start);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;
            max = Math.max(max, count[server]);

            busy.offer(new int[]{
                server, arrival[i] + load[i]
            });
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
