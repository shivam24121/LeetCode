class Solution {
    public int maxLevelSum(TreeNode root) {
       ArrayList<Integer>res=new ArrayList<>();

        Queue<TreeNode>q=new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }
            res.add(sum);
        }
        int ansIdx=1;
        int max=root.val;

        for(int i=1;i<res.size();i++){
            if(res.get(i)>max){
                ansIdx=i+1;
                max=res.get(i);
            }
        }
        return ansIdx;
    }
}
