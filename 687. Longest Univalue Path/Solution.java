/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int max=0;
    
    public int longestUnivaluePath(TreeNode root) {
        solve(root);
        return max;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;
        
        int left=solve(root.left);
        int right=solve(root.right);

        int ansL=0,ansR=0;

        if(root.left!=null && root.val==root.left.val)ansL=left+1;
        if(root.right!=null && root.val==root.right.val)ansR=right+1;

        
        max=Math.max(max,ansL+ansR);

        return Math.max(ansL,ansR);
    }
}
