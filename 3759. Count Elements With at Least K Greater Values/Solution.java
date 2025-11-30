class Solution {
    public int countElements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);

        Map<Integer,Integer>map=new LinkedHashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int res=0;
        int temp=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int curr=entry.getKey();
            int currVal=entry.getValue();

            temp+=currVal;
            int rem=n-temp;

            if(rem>=k){
                res+=currVal;
            }
        }
        return res;
    }
}
