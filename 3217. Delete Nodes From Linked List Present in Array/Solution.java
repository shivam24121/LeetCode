class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        ListNode dummy=new ListNode(0,head);
        ListNode curr=dummy;

        while(curr.next!=null){
            if(set.contains(curr.next.val)){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}
