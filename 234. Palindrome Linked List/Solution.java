class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode secHead=reverse(slow);

        while(curr!=secHead && secHead!=null){
            if(curr.val!=secHead.val){
                return false;
            }
            curr=curr.next;
            secHead=secHead.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head){
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
