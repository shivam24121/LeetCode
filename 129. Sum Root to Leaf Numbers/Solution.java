class Solution {
    int res=0;
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return res;
    }
    public void solve(TreeNode root,int x){
        if(root==null)return;

        if(root.left==null && root.right==null){
            x=x*10+root.val;
            res+=x;
            return;
        }

        solve(root.left,x*10+root.val);
        solve(root.right,x*10+root.val);
    }
}
