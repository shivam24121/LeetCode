class Solution {
    public int longestSubarray(int[] nums, int k) {
        
        int n=nums.length;
        TreeMap<Integer,Integer>map=new TreeMap<>();

        int res=0;
        int l=0;

        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.lastKey()-map.firstKey()>k){

                int temp=nums[l];
                map.put(temp,map.getOrDefault(temp,0)-1);
                if(map.get(temp)==0){
                    map.remove(temp);
                }
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
