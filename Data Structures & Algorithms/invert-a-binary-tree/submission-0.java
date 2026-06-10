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

class Solution {
    public TreeNode invertTree(TreeNode root) {

        return dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        if(root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = dfs(root.right);
        node.right = dfs(root.left);
        return node;
    }
}
