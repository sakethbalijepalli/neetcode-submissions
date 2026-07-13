/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldNodeToNewNode = new HashMap<>();
        return dfs(node,oldNodeToNewNode);
    }

    private Node dfs(Node node,HashMap<Node, Node> oldNodeToNewNode){
        if(node == null) return null;

        if(oldNodeToNewNode.containsKey(node)){
            return oldNodeToNewNode.get(node);
        }
        Node copyOfOld = new Node(node.val);
        oldNodeToNewNode.put(node,copyOfOld);

        for(Node nei : node.neighbors){
            copyOfOld.neighbors.add(dfs(nei,oldNodeToNewNode));
        }
        return copyOfOld;
    }
}