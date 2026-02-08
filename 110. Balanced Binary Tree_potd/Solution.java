class Solution {
    public boolean isBalanced(TreeNode root) {
        if(solve(root)==-1)return false;
        return true;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;

        int l=solve(root.left);
        if(l==-1)return -1;

        int r=solve(root.right);
        if(r==-1)return -1;

        if(Math.abs(l-r)>1)return -1;

        return 1+Math.max(l,r);
    }
}
