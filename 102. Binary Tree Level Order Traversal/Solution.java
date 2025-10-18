class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer>res=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=queue.remove();
                res.add(curr.val);
                if(curr.left!=null)queue.add(curr.left);
                if(curr.right!=null)queue.add(curr.right);
            }
            ans.add(res);
        }
        return ans;
    }
}
