class Solution {
    Map<TreeNode,Integer> dp=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)return 0;
        if(dp.containsKey(root))return dp.get(root);

        int pick=root.val;

        if(root.left!=null){
            pick+=rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            pick+=rob(root.right.left) + rob(root.right.right);
        }

        int skip=rob(root.left)+rob(root.right);

        int res=Math.max(skip,pick);
        dp.put(root,res);
        return res;
    }
}
