class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)return head;

        ListNode curr=head;
        int ct=0;
        while(curr!=null && ct<k){
            curr=curr.next;
            ct++;
        }
        if(ct<k)return head;

        ListNode prev=null,next=null;
        curr=head;
        ct=0;
        while(curr!=null && ct<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            ct++;
        }
        head.next=reverseKGroup(curr,k);
        return prev;
    }
}
