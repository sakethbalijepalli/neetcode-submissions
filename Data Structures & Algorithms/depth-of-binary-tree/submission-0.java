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
    public int maxDepth(TreeNode root) {
         Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }
        int count = 0;
        while (!treeNodeDeque.isEmpty()){
            int length = treeNodeDeque.size();
            for(int i = 0;i < length;i++){
                TreeNode node = treeNodeDeque.removeFirst();
                if(node.left != null){
                    treeNodeDeque.add(node.left);
                }
                if(node.right != null){
                    treeNodeDeque.add(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
