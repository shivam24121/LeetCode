class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit){
        TreeNode curr=solve(root,limit);
        return curr;
    }
    public TreeNode solve(TreeNode root,int sum){

        if(root==null)return null;
        
        // if(root==null)return null;
        // System.out.println(root.val+" "+sum);

        if(root.left==null && root.right==null){
            return root.val>=sum?root:null;
        }
        else{

            root.left=solve(root.left,sum-root.val);
            root.right=solve(root.right,sum-root.val);

            if(root.left==null && root.right==null){
                return null;
            }
            return root;
        }
    }
}
