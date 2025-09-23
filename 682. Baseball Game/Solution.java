class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("+")){
                if(st.size()>=2){
                    int a=st.pop();
                    int b=st.peek();
                    st.push(a);
                    st.push(a+b);
                }
            }
            else if(operations[i].equals("D")){
                if(!st.isEmpty()){
                    st.push(st.peek()*2);
                }
            }
            else if(operations[i].equals("C")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}
