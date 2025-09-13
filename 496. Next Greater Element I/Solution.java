class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i:nums2){
            while(!st.isEmpty() && i>st.peek()){
                map.put(st.pop(),i);
            }
            st.push(i);
        }
        int idx=0;
        for(int i:nums1){
            nums1[idx++]=map.getOrDefault(i,-1);
        }
        return nums1;
    }
}
