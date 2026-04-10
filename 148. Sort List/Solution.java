class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer>list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        ListNode dummy=new ListNode(-1);
        ListNode root=head;
        dummy.next=root;
        Collections.sort(list);
        int idx=0;

        while(root!=null){
            root.val=list.get(idx++);
            root=root.next;
        }
        return dummy.next;
    }
}
