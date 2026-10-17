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
    public int level(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(level(root.left), level(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int my = level(root.left) + level(root.right);

        int lef = diameterOfBinaryTree(root.left);
        int rig = diameterOfBinaryTree(root.right);

        return Math.max(my, Math.max(lef, rig));
    }
}

/*// Time Complexity: O(n^2)
// Space Complexity: O(n)
// n = Number of nodes in the binary tree */
