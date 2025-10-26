class Solution {

    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>temp=new ArrayList<>();
        solve(0,temp,candidates,target);
        return res;
    }
    public void solve(int idx,List<Integer> temp,int[] nums,int target){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(idx==nums.length || target<0)return;

        temp.add(nums[idx]);
        solve(idx,temp,nums,target-nums[idx]);
        temp.remove(temp.size()-1);
        solve(idx+1,temp,nums,target);
    }
}
