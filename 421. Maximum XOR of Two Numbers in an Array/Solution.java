class Solution {
    static class Node{
        Node left;
        Node right;
    }
    public void insert(Node head,int n){
        Node root=head;
        for(int i=31;i>=0;i--){
            int bit=((n>>i)&1);
            if(bit==1){
                if(root.right==null){
                    root.right=new Node();
                }
                root=root.right;
            }
            else{
                if(root.left==null){
                    root.left=new Node();
                }
                root=root.left;
            }
        }
    }
    public int search(Node head,int n){
        int res=0;
        Node root=head;
        for(int i=31;i>=0;i--){
            int bit=((n>>i)&1);
            if(bit==1){
                if(root.left!=null){
                    res|=(1<<i);
                    root=root.left;
                }
                else{
                    root=root.right;
                }
            }
            else{
                if(root.right!=null){
                    res|=(1<<i);
                    root=root.right;
                }
                else{
                    root=root.left;
                }
            }
        }
        return res;
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        int res=0;
        for(int i:nums){
            insert(root,i);
        }
        for(int i=0;i<nums.length;i++){
            res=Math.max(res,search(root,nums[i]));
        }
        return res;
    }
}
