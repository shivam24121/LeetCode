class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev=head;
        ListNode slow=head;
        ListNode fast=head;

        if(head.next==null)return null;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
}
