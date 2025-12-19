class Solution {
    Map<TreeNode,Integer>map=new HashMap<>();
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        int left=0;
        int right=0;

        if(map.containsKey(root.left)){
            left=map.get(root.left);
        }
        else{
            left=Math.max(0,dfs(root.left));
        }

        if(map.containsKey(root.right)){
            right=map.get(root.right);
        }
        else{
            right=Math.max(0,dfs(root.right));
        }

        max=Math.max(max,left+right+root.val);
        map.put(root,max);

        return Math.max(left,right)+root.val;
    }
}
