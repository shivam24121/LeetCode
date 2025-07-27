class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> l=new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                l.add(nums[i]);
            }
        }
        int ct=0;
        for(int i=1;i<l.size()-1;i++){
            int prev=l.get(i-1);
            int curr=l.get(i);
            int next=l.get(i+1);
            if(curr>prev && curr>next || curr<prev && curr<next)ct++;
        }
        return ct;
    }

}
