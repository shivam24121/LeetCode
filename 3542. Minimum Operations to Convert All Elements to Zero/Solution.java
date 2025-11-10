class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer>st=new Stack<>();
        int ct=0;

        for(int i:nums){
            while(!st.isEmpty() && i<st.peek()){
                st.pop();
            }
            if(i==0)continue;

            if(st.isEmpty() || st.peek()<i){
                st.push(i);
                ct++;
            }
        }
        return ct;
    }
}
