class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkMirror(root.left, root.right);
    }

    public boolean checkMirror(TreeNode left, TreeNode right) {

        // Both nodes are empty
        if (left == null && right == null) {
            return true;
        }

        // Only one node is empty
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return checkMirror(left.left, right.right)
            && checkMirror(left.right, right.left);
    }
}