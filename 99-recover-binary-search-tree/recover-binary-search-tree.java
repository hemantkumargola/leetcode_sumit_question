

class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left subtree
        inorder(root.left);

        // Check BST violation
        if (pre != null && pre.val > root.val) {

            if (first == null) {
                first = pre;
            }

            second = root;
        }

        // Update previous node
        pre = root;

        // Right subtree
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Swap the two incorrect nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}