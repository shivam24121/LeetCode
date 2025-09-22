class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        boolean fl=true;

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                l.add(curr.val);

                if(curr.left!=null)queue.add(curr.left);
                if(curr.right!=null)queue.add(curr.right);
            }
            if(!fl){
                Collections.reverse(l);
            }
            res.add(l);
            fl=!fl;
            
        }
        return res;

    }
}
