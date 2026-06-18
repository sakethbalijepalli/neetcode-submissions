class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;
    // null <- left <-> right
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }


    public int get(int key) {
        // Return the value corresponding to the key if exists,
        // if it doesnt exist then return -1
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // update the value of the key if key exists,
        // otherwise we add key value pair
        // if adding this new key exceeds the capacity,
        //then we remove the least recently used key.
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            moveToHead(cache.get(key));
            return;
        }
        Node newNode = new Node(key,value);
        if(cache.size() == cap){
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        cache.put(key,newNode);
        addNodeTohead(newNode);
    }

    private void removeNode(Node node){
        if(node != null){
            // tail is the dummy
            // null <- head <-> 1 <-> 2 <-> tail -> null
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void addNodeTohead(Node node){
        if(node != null){
            Node tempNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = tempNode;
            tempNode.prev = node;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNodeTohead(node);
    }
}
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}