class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){

        Map<TreeNode,TreeNode>map=new HashMap<>();
        built(map,root,null);

        // System.out.println(map);

        Queue<TreeNode>q=new ArrayDeque<>();
        Set<TreeNode>set=new HashSet<>();

        q.offer(target);
        set.add(target);

        int ct=0;

        ArrayList<Integer>res=new ArrayList<>();

        while(!q.isEmpty()){

            int n=q.size();

            if(ct==k){
                while(!q.isEmpty()){
                    res.add(q.poll().val);
                }
                return res;
            }
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    q.offer(curr.right);
                    set.add(curr.right);
                }
                if(map.get(curr)!=null && !set.contains(map.get(curr))){
                    q.offer(map.get(curr));
                    set.add(map.get(curr));
                }
            }
            ct++;
        }
        return res;
    }
    public void built(Map<TreeNode,TreeNode>map,TreeNode node,TreeNode par){

        if(node==null){
            return;
        }
        map.put(node,par);
        built(map,node.left,node);
        built(map,node.right,node);
    }
}
