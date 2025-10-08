class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode curr=head;
        int len=1;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }

        curr.next=head;

        int shift=len- k%len;
        ListNode temp=head;
        for(int i=1;i<shift;i++){
            temp=temp.next;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        return newHead;
    }
}
