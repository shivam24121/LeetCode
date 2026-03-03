class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode largeHead=new ListNode(-1);
        ListNode smallHead=new ListNode(-1);

        ListNode small=smallHead;
        ListNode large=largeHead;

        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                small.next=curr;
                small=small.next;
            }
            else{
                large.next=curr;
                large=large.next;
            }
            curr=curr.next;
        }
        large.next=null;
        small.next=largeHead.next;
        return smallHead.next;
    }
}
