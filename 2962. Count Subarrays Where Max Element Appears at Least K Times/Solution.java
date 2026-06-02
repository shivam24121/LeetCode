class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int max=Arrays.stream(nums).max().getAsInt();
        int n=nums.length;

        ArrayList<Integer>list=new ArrayList<>();
        long res=0;

        for(int i=0;i<n;i++){
            if(nums[i]==max){
                list.add(i);
            }
            if(list.size()>=k){
                res+=(list.get(list.size()-k)+1);
            }
        }

        return res;
    }
}
