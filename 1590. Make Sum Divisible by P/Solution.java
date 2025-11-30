class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0,res=n;

        for(int i:nums){
            sum=(sum+i)%p;
        }
        int target=sum%p;

        if(target==0)return 0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);

        int curr=0;
        for(int i=0;i<n;i++){
            curr=(curr+nums[i])%p;
            int rem=(curr-target+p)%p;

            if(map.containsKey(rem)){
                res=Math.min(res,i-map.get(rem));
            }
            map.put(curr,i);
        }
        return res==n?-1:res;
    }
}
