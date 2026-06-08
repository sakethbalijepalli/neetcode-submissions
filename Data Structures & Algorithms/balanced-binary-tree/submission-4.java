class Solution {
    public static boolean isBalanced(TreeNode root) {
        return traverseBottomUp(root) != -1;
    }
    
    private static int traverseBottomUp(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = traverseBottomUp(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = traverseBottomUp(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}