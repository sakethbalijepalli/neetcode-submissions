/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
 public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }
    private int index = 0;

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        index = 0;
        return buildTree(tokens);
    }

    private TreeNode buildTree(String[] tokens) {
        if (index >= tokens.length || tokens[index].equals("N")) {
            index++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(tokens[index++]));
        
        node.left = buildTree(tokens);
        node.right = buildTree(tokens);

        return node;
    }
}
