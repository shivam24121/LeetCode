class Solution {
    public TreeNode createBinaryTree(int[][] arr) {
        
        Map<Integer,TreeNode>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();

        for(int[] e:arr){

            int par=e[0];
            int cld=e[1];
            int left=e[2];

            map.put(par,new TreeNode(par));
            map.put(cld,new TreeNode(cld));
            set.add(par);
        }
        TreeNode root=null;

        for(int[] e:arr){

            int par=e[0];
            int cld=e[1];
            int lft=e[2];

            TreeNode curr=map.get(par);
            if(lft==1){
                curr.left=map.get(cld);
            }
            else{
                curr.right=map.get(cld);
            }
            set.remove(cld);
        }
        for(int x:set){
            root=map.get(x);
        }
        return root;
    }
}

