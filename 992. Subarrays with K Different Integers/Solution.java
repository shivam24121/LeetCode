class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return solve(nums,k)-solve(nums,k-1);
    }
    public int solve(int[] nums,int k){

        int n=nums.length;
        int res=0;

        Map<Integer,Integer>map=new HashMap<>();

        int l=0;
        for(int r=0;r<n;r++){
            
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.size()>k){
                int left=nums[l];
                map.put(left,map.getOrDefault(left,0)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                l++;
            }
            res+=(r-l+1);
        }
        return res;
    }
}
