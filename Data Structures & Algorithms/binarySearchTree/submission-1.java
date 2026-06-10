class TreeMap {
    TreeNodes root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNodes newNode = new TreeNodes(key,val);
        if(root == null){
            root = newNode;
            return;
        }

        TreeNodes curr = root;
        while (true){
            if(key < curr.key){
                if(curr.left == null){
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            }
            else if(key > curr.key){
                if(curr.right == null){
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            }
            else{
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNodes curr = root;
        while (curr != null){
            if(key < curr.key){
                curr = curr.left;
            }else if(key > curr.key){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNodes current = findMin(this.root);
        return (current != null) ? current.val : -1;
    }

    private TreeNodes findMin(TreeNodes node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        TreeNodes curr = findMax(this.root);
        return (curr != null) ? curr.val : -1;
    }

    private TreeNodes findMax(TreeNodes node) {
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void remove(int key) {
        TreeNodes curr = root;
        TreeNodes parent = null;

        while (curr != null && curr.key != key){
            parent = curr;
            if(key < curr.key){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        if(curr == null) return;

        if (curr.left == null || curr.right == null) {

            TreeNodes child = (curr.left != null) ? curr.left : curr.right;

            if (parent == null) {
                root = child;
            } else {

                if(parent.left == curr){
                    parent.left = child;
                } else if (parent.right == curr) {
                    parent.right = child;
                }
            }
        }

        else {

            TreeNodes successorParent = curr;
            TreeNodes successor = curr.right;


            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }


            curr.key = successor.key;
            curr.val = successor.val;


            if (successorParent == curr) {
                successorParent.right = successor.right;
            } else {

                successorParent.left = successor.right;
            }
        }
    }


    public List<Integer> getInorderKeys() {
        List<Integer> keyList = new ArrayList<>();
        inOrder(root,keyList);
        return keyList;
    }

    private void inOrder(TreeNodes root, List<Integer> keyList){
        if(root == null) return;
        inOrder(root.left,keyList);
        keyList.add(root.key);
        inOrder(root.right,keyList);
    }

    static class TreeNodes {
        int key;
        int val;
        TreeNodes left;
        TreeNodes right;

        public TreeNodes(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }
}