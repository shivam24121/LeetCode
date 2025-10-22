class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> freq=new HashMap<>();
        TreeMap<Integer,Integer> diff=new TreeMap<>();

        int max=Arrays.stream(nums).max().getAsInt() + k;
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);

            int l=Math.max(0,i-k);
            int r=Math.min(max,i+k);

            diff.put(l, diff.getOrDefault(l,0)+1);
            diff.put(r+1, diff.getOrDefault(r+1,0)-1);

            diff.put(i, diff.getOrDefault(i,0)+0);
        }
        int res=1;
        int cumSum=0;

        for(Map.Entry<Integer,Integer>entry:diff.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();

            cumSum+=val;

            int f=freq.getOrDefault(key,0);
            int convert=cumSum-f;

            int maxOps=Math.min(numOperations,convert);
            res=Math.max(res,maxOps+f);
        }
        return res;
    }
}
