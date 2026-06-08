class Solution {
   public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}