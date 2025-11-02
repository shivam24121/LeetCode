class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode>q=new LinkedList<>();
        int ct=0;
        q.offer(root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                ct++;
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }
        }
        return ct;
    }
}
