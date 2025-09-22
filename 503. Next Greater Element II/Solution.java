class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] temp=new int[2*n];
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            temp[i]=nums[i];
            temp[i+n]=nums[i];
        }
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n*2;i++){
            while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                int idx=st.pop();
                res[idx%n]=temp[i];
            }
            st.push(i);
        }
        return res;
    }
}
