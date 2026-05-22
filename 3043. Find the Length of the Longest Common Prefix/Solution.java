class Solution {

    class Node{

        Node[] child;

        Node(){
            child=new Node[10];
        }
    }
    public Node root;

    public int query(String s){

        int n=s.length();
        Node curr=root;
        int ct=0;

        for(int i=0;i<n;i++){

            int pos=s.charAt(i)-'0';

            if(curr.child[pos]==null){
                return ct;
            }
            ct++;
            curr=curr.child[pos];
        }
        return ct;
    }

    public void insert(String s){

        int n=s.length();
        Node curr=root;

        for(int i=0;i<n;i++){

            int pos=s.charAt(i)-'0';

            if(curr.child[pos]==null){
                curr.child[pos]=new Node();
            }
            curr=curr.child[pos];
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        int n=arr1.length;
        int m=arr2.length;

        root=new Node();

        for(int i:arr1){
            String s=String.valueOf(i);
            insert(s);
        }
        int res=0;

        for(int i:arr2){
            String s=String.valueOf(i);
            res=Math.max(res,query(s));
        }
        return res;
    }
}
