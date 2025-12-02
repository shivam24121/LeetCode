class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                res=Math.min(res,i-map.get(nums[i]));
            }
            int rev=reverse(nums[i]);
            map.put(rev,i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int reverse(int n){
        int res=0;
        while(n>0){
            int d=n%10;
            res=(res*10)+d;
            n=n/10;
        }
        return res;
    }
}
