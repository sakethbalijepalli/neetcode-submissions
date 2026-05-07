class DoubleEndedQueue {
    int val;
    DoubleEndedQueue next;
    DoubleEndedQueue prev;

    public DoubleEndedQueue(int val){
        this.val = val;
        next = null;
        prev = null;
    }
}

class Deque {
    private DoubleEndedQueue head;
    private DoubleEndedQueue tail;

    public Deque() {
        this.head = null;
        this.tail = null;
    }

    void main() {
        Deque deque = new Deque();
        deque.append(10);
        deque.appendleft(20);
        System.out.println(deque.popleft());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        deque.append(30);
        System.out.println(deque.pop());
        System.out.println(deque.isEmpty());
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void append(int value) {
        DoubleEndedQueue newNode = new DoubleEndedQueue(value);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public void appendleft(int value) {
        DoubleEndedQueue newNode = new DoubleEndedQueue(value);
        if(head == null){
            head = tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

    }

    public int pop() {
        if(!isEmpty()){
            int poppedNode = tail.val;
            tail = tail.prev;
            if (tail == null) head = null;
            else tail.next = null;
            return poppedNode;
        }
        return -1;
    }

    public int popleft() {
        if(!isEmpty()){
            int poppedNode = head.val;
            head = head.next;
            if (head == null) tail = null;
            else head.prev = null;
            return poppedNode;
        }
        return -1;
    }
}
