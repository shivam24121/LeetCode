class MyQueue {

    Stack<Integer>input;
    Stack<Integer>output;
    int peek=-1;

    public MyQueue() {
        
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        
        if(input.isEmpty()){
            peek=x;
        }
        input.push(x);
    }
    
    public int pop() {
        
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        
        if(!output.isEmpty()){
            return output.peek();
        }
        return peek;
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
