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
    public List<Integer> rightSideView(TreeNode root) {
        //        We want the right side view nodes only.
//        1          <-- Level 0
//      /   \
//     2     3       <-- Level 1
//    / \   / \
//   4  N  N   N     <-- Level 2
//  /
// 5                 <-- Level 3
//        In the above example we see 4 and 5 because 2 doesnt have any children or 4 doesnt have children or
// For every level we can just pick the last element. 
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        if(root != null){
            treeNodeDeque.add(root);
        }
        while (!treeNodeDeque.isEmpty()){
            int len = treeNodeDeque.size();
            for (int i = 0;i < len;i++){
                TreeNode curr = treeNodeDeque.removeFirst();
                if(curr.left != null){
                    treeNodeDeque.add(curr.left);
                }
                if(curr.right != null){
                    treeNodeDeque.add(curr.right);
                }
                if(i == len - 1){
                resList.add(curr.val);
                }
            }
        }
        return resList;
    }
}
