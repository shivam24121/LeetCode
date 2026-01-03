class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int l=0;
        int max=Integer.MAX_VALUE;

        int total=0;
        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.get(nums[r])==1){
                total+=nums[r];
            }
            while(total>=k){
                max=Math.min(max,r-l+1);
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                    total-=nums[l];
                }
                l++;
            }
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}©leetcode
