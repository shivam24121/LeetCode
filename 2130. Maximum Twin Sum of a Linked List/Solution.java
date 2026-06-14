class Solution {
    public int pairSum(ListNode head) {
        
        ListNode curr=head;

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode back=rev(slow);

        int res=0;

        while(curr!=null && back!=null){
            res=Math.max(res,curr.val+back.val);
            curr=curr.next;
            back=back.next;
        }
        return res;
    }
    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode prev=null,next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
