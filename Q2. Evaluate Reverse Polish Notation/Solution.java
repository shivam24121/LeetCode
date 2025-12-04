class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        int res=0;

        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(tokens[i].matches("-?\\d+")){
                int x=Integer.parseInt(tokens[i]);
                st.push(x);
            }
            else{
                if(st.size()>=2){
                    int b=st.pop();
                    int a=st.pop();
                    int ans=solve(a,b,tokens[i]);
                    st.push(ans);
                }
            }
        }
        return st.pop();
    }
    public int solve(int a,int b,String c){
        switch(c){
            case "+":return a+b;
            case "-":return a-b;
            case "*":return a*b;
            case "/":return a/b;
        }
        return 0;
    }
}
