class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public MinStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!tempStack.isEmpty()){
            val = Math.min(val, tempStack.peek());
        }
        tempStack.push(val);
    }
    
    public void pop() {
        stack.pop();
        tempStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {

        return tempStack.peek();
    }
}
