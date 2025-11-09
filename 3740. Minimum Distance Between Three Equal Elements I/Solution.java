class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        if(n<=2)return -1;

        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int curr=nums[i];

            map.putIfAbsent(curr,new ArrayList<>());
            map.get(curr).add(i);
        }

        int dist=Integer.MAX_VALUE;

        for(List<Integer>entry:map.values()){
            if(entry.size()<3)continue;

            for(int i=0;i<=entry.size()-3;i++){
                int min=entry.get(i);
                int max=entry.get(i+2);

                dist=Math.min(dist,2*(max-min));
            }
        }
        if(dist==Integer.MAX_VALUE){
            return -1;
        }
        return dist;
    }
}
