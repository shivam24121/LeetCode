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
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root,new StringBuilder());
        return ans;
    }
    public void solve(TreeNode root,StringBuilder sb){
        if(root==null)return;
        if(root.left==null && root.right==null){
            sb.append(root.val);
            // System.out.println("before"+ans);
            int temp=Integer.parseInt(sb.toString(),2);
            // System.out.println(temp);
            ans+=temp;
            // System.out.println("after"+ans);
        }
        else{
            sb.append(root.val);
            solve(root.left,sb);
            solve(root.right,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}
