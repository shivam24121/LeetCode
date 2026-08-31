class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode curr=head;
        ArrayList<Integer>list=new ArrayList<>();

        int[] res={100001,100001};
        int prev=curr.val;
        curr=curr.next;
        int idx=1;
        int lastCritical=-1;

        while(curr!=null && curr.next!=null){

            if(curr.val>prev && curr.val>curr.next.val){
                if(list.size()!=0){
                    res[0]=Math.min(res[0],idx-list.get(list.size()-1));
                }
                list.add(idx);
            }
            if(curr.val<prev && curr.val<curr.next.val){
                if(list.size()!=0){
                    res[0]=Math.min(res[0],idx-list.get(list.size()-1));
                }
                list.add(idx);
            }
            idx++;
            prev=curr.val;
            curr=curr.next;
        }
        // for(int i:list){
        //     System.out.print(i+" ");
        // }
        if(list.size()<2){
            return new int[]{-1,-1};
        } 
        res[1]=list.get(list.size()-1)-list.get(0);
        return res;  
    }
}
