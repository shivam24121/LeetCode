class Solution {
    List<List<Integer>>l=new ArrayList<>();
    public void solve(int idx,int[] nums,List<Integer>temp){
        if(idx>=nums.length){
            l.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,nums,temp);
        temp.remove(temp.size()-1);
        solve(idx+1,nums,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        solve(0,nums,temp);
        return l;
    }
}
