class Solution {

    int res=0;

    public int goodNodes(TreeNode root) {

        solve(root,Integer.MIN_VALUE);
        return res;
    }
    public void solve(TreeNode root,int tight){

        if(root==null){
            return;
        }
        int nextTight=tight;

        if(root.val>=tight){
            nextTight=root.val;
            res++;
        }
        solve(root.left,nextTight);
        solve(root.right,nextTight);
    }
}
