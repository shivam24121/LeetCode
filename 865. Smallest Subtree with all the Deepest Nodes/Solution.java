class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return null;

        TreeNode ans;
        
        int l=height(root.left);
        int r=height(root.right);

        if(l==r){
            return root;
        }

        if(l>r){
            ans=subtreeWithAllDeepest(root.left);
        }
        else{
            ans=subtreeWithAllDeepest(root.right);
        }
        return ans;
    }
    public int height(TreeNode root){
        if(root==null)return 0;

        int l=height(root.left);
        int r=height(root.right);

        return Math.max(l,r)+1;
    }
}
