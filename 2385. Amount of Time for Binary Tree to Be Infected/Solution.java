class Solution {
    
    int time=0;

    public int amountOfTime(TreeNode root, int start) {
        solve(root,start);
        return time;
    }
    public int solve(TreeNode root,int start){
        if(root==null)return 0;

        int l=solve(root.left,start);
        int r=solve(root.right,start);

        if(root.val==start){
            time=Math.max(time,Math.max(l,r));
            return -1;
        }
        else if(l>=0 && r>=0){
            return Math.max(l,r)+1;
        }
        else{
            int dist=Math.abs(l)+Math.abs(r);
            time=Math.max(time,dist);
            return Math.min(l,r)-1;
        }
    }
}
