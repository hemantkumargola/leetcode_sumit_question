class Solution {
    int sum = 0;

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.right);

        sum += root.val;
        root.val = sum;

        inorder(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inorder(root);
        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h)
// Worst Case Space: O(n)