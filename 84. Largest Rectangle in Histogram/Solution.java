class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int sum=0;
        for(int i=0;i<=n;i++){
            int h=(i==n)?0:heights[i];
            while(!st.isEmpty() && h<heights[st.peek()]){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                sum=Math.max(sum,height*width);
            }
            st.push(i);
        }
        return sum;
    }
}
