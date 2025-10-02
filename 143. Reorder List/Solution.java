class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode>st=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            st.push(curr);
            curr=curr.next;
        }
        int k=st.size()/2;
        curr=head;

        while(k-->0){
            ListNode temp=st.peek();
            st.pop();
            ListNode aage=curr.next;
            curr.next=temp;
            temp.next=aage;
            curr=aage;
        }
        curr.next=null;
    }
}
