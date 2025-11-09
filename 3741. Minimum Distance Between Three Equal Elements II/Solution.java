class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());

            map.get(nums[i]).add(i);
        }

        int res=Integer.MAX_VALUE;

        for(List<Integer> entry:map.values()){
            if(entry.size()<3)continue;
        
            for(int i=0;i<=entry.size()-3;i++){
                int min=entry.get(i);
                int max=entry.get(i+2);
    
                res=Math.min(res,2*(max-min));
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
