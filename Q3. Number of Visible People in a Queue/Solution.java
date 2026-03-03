class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            int ct=0;
            while(!st.isEmpty() && heights[i]>heights[st.peek()]){
                st.pop();
                ct++;
            }
            if(!st.isEmpty())ct++;
            res[i]=ct;
            st.push(i);
        }
        return res;
    }
}
