class Solution {

    int moves=0;

    public int distributeCoins(TreeNode root) {
        solve(root);
        return moves;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;

        int l=solve(root.left);
        int r=solve(root.right);

        moves+=Math.abs(r)+Math.abs(l);
        
        return root.val+l+r-1;
    }
}
