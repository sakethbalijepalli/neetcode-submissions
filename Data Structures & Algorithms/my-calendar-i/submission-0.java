class MyCalendar {

    private class Node {
        int max;
        int lazy;
        Node left;
        Node right;
    }

    private Node root;
    private static final int MAX_TIME = 1_000_000_000;

    public MyCalendar() {
        root = new Node();
    }

    public boolean book(int startTime, int endTime) {
        int start = startTime;
        int end = endTime - 1;

        if (query(root, 0, MAX_TIME, start, end) >= 1) {
            return false;
        }

        update(root, 0, MAX_TIME, start, end, 1);
        return true;
    }

    private int query(Node node, int l, int r, int ql, int qr) {
        if (l > qr || r < ql) {
            return 0;
        }
        if (ql <= l && r <= qr) {
            return node.max;
        }
        pushDown(node);

        int mid = l + (r - l) / 2;
        return Math.max(query(node.left, l, mid, ql, qr), query(node.right, mid + 1, r, ql, qr));
    }

    private void update(Node node, int l, int r, int ul, int ur, int val) {
        if (l > ur || r < ul) {
            return;
        }
        if (ul <= l && r <= ur) {
            node.max += val;
            node.lazy += val;
            return;
        }

        pushDown(node);

        int mid = l + (r - l) / 2;
        update(node.left, l, mid, ul, ur, val);
        update(node.right, mid + 1, r, ul, ur, val);
        node.max = Math.max(node.left.max, node.right.max);
    }

    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();

        if (node.lazy > 0) {
            node.left.max += node.lazy;
            node.left.lazy += node.lazy;
            node.right.max += node.lazy;
            node.right.lazy += node.lazy;
            node.lazy = 0;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */