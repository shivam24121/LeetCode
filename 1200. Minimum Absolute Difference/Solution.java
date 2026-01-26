class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {

        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;

        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            int diff=nums[i+1]-nums[i];
            if(diff<min){
                min=diff;
                res.clear();
                res.add(Arrays.asList(nums[i],nums[i+1]));
            }
            else if(diff==min){
                res.add(Arrays.asList(nums[i],nums[i+1]));
            }
        }
        return res;
    }
}
