
class Solution {

    int res=0;

    public int averageOfSubtree(TreeNode root) {
        
        solve(root);
        return res;
    }
    public int[] solve(TreeNode root){

        if(root==null){
            return new int[]{0,0};
        }

        int[] l=solve(root.left);
        int[] r=solve(root.right);

        int sum=root.val+l[0]+r[0];
        int size=1+l[1]+r[1];

        if(sum/size==root.val){
            res++;
        }
        return new int[]{sum,size};
    }
}
