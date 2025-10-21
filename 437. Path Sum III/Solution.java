class Solution {
    public int pathSum(TreeNode root, long targetSum) {
        if(root==null)return 0;
        int curr=solve(root,targetSum);
        int l=pathSum(root.left,targetSum);
        int r=pathSum(root.right,targetSum);
        return curr+l+r;
    }
    public int solve(TreeNode root,long t){
        if(root==null)return 0;
        int ct=0;
        if(root.val==t){
            ct++;
        }
        ct+=solve(root.left,t-root.val);
        ct+=solve(root.right,t-root.val);
        return ct;
    }
}
