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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;

        HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        TreeNode node = new TreeNode(preorder[preStart]);

        int rootIndex = inOrderMap.get(node.val);
        int leftSubtreeSize = rootIndex - inStart;
        node.left = build(preorder,preStart + 1, preStart + leftSubtreeSize,inorder,
                inStart, rootIndex - 1);

        node.right = build(preorder,preStart + leftSubtreeSize + 1, preEnd,inorder,
                rootIndex + 1, inEnd);
        return node;
    }
}
