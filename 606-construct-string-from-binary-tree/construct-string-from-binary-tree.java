class Solution {
    public String tree2str(TreeNode root) {

        // Base case
        if (root == null) {
            return "";
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        // Only left child
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }

        // Right child exists
        return root.val + "(" + tree2str(root.left) + ")("
                + tree2str(root.right) + ")";
    }
}