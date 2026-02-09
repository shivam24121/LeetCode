class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer>res=new ArrayList<>();
        solve(root,res);
        return help(res,0,res.size()-1);
    }
    public void solve(TreeNode root,ArrayList<Integer>res){
        if(root==null)return;

        solve(root.left,res);
        res.add(root.val);
        solve(root.right,res);
    }
    public TreeNode help(ArrayList<Integer>res,int l,int r){
        if(l>r)return null;

        int mid=l+(r-l)/2;

        TreeNode root=new TreeNode(res.get(mid));
        root.left=help(res,l,mid-1);
        root.right=help(res,mid+1,r);

        return root;
    }
}
