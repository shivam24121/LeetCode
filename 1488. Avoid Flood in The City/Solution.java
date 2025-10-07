class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        Map<Integer, Integer> lastFill = new HashMap<>();
        TreeSet<Integer> drySet = new TreeSet<>();
        int[] result = new int[len];
        Arrays.fill(result, 1);

        for (int day = 0; day < len; day++) {
            int lake = rains[day];

            if (lake == 0) {
                drySet.add(day);
            } else {
                result[day] = -1;

                if (lastFill.containsKey(lake)) {
                    Integer dry = drySet.higher(lastFill.get(lake));
                    if (dry == null) return new int[0];
                    result[dry] = lake;
                    drySet.remove(dry);
                }

                lastFill.put(lake, day);
            }
        }

        return result;
    }
}
