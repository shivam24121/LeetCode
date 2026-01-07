class Solution {

    ArrayList<Long>subTree;
    int mod=(int)1e9+7;

    public int maxProduct(TreeNode root) {
        subTree=new ArrayList<>();
        long total=dfs(root);

        long res=Integer.MIN_VALUE;

        for(int i=0;i<subTree.size();i++){
            res=Math.max(res,(total-subTree.get(i))*subTree.get(i));
        }
        return (int)(res%mod);
    }
    public long dfs(TreeNode root){
        if(root==null)return 0;

        long left=dfs(root.left);
        long right=dfs(root.right);

        long sum=root.val+left+right;
        subTree.add(sum);
        return sum;
    }
}
