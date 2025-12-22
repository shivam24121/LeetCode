class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)return 0;
        solve(root.left,1,true);
        solve(root.right,1,false);
        return max;
    }
    public void solve(TreeNode root,int res,boolean left){
        if(root==null)return;

        max=Math.max(max,res);

        if(left){
            solve(root.right,res+1,false);
            solve(root.left,1,true);
        } 
        else{
            solve(root.left,res+1,true);
            solve(root.right,1,false);
        }
    }
}
