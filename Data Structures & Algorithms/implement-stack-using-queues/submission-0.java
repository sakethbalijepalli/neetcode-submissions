
class MyStack {
    private Queue<Integer> q1;

    public MyStack() {
        this.q1 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        Queue<Integer> elementsPopped = new LinkedList<>();
        int size = q1.size();
        if(!empty()){
            for(int i = 0; i < size - 1;i++){
                elementsPopped.offer(q1.poll());
            }
        }

        Integer poppedElement = q1.poll();
        q1 = elementsPopped;
        return poppedElement.intValue();
    }

    public int top() {
        Queue<Integer> elementsPopped = new LinkedList<>();
        int size = q1.size();
        if(!empty()){
            for(int i = 0; i < size - 1;i++){
                elementsPopped.offer(q1.poll());
            }
        }

        Integer peekedElement = q1.peek();
        elementsPopped.offer(peekedElement);
        q1 = elementsPopped;
        return peekedElement.intValue();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */