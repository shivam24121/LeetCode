class Solution {
    int ct=0,res=-1;
    public int kthSmallest(TreeNode root, int k) {
        solve(root,k);
        return res;
    }
    public void solve(TreeNode root,int k){
        if(root==null || ct>=k)return ;
        solve(root.left,k);
        ct++;
        if(ct==k){
            res=root.val;
            return;
        }
        solve(root.right,k);
    }
}
