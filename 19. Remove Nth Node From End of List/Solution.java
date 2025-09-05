/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        ListNode temp=head;
        int ct=0;
        while(temp!=null){
            ct++;
            temp=temp.next;
        }
        return ct;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int llsize=length(head);
        int dis=llsize-n;
        if(dis==0)return head.next;
        ListNode prev=null;
        ListNode curr=head;
        while(dis>0){
            prev=curr;
            curr=curr.next;
            dis--;
        }
        prev.next=curr.next;
        return head;
    }
}
