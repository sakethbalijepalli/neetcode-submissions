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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();

        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }

        while (!treeNodeDeque.isEmpty()){
            int len = treeNodeDeque.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i < len;i++){
                TreeNode curr = treeNodeDeque.removeFirst();
                res.add(curr.val);
                if(curr.left != null){
                    treeNodeDeque.add(curr.left);
                }
                if(curr.right != null){
                    treeNodeDeque.add(curr.right);
                }
            }
            resList.add(res);
        }
        return resList;
    }
}
