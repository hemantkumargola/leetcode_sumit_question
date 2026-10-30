class Solution {

    public boolean exists(TreeNode root, TreeNode node) {
        if (root == node) return true;
        if (root == null) return false;

        return exists(root.left, node) || exists(root.right, node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q)
            return root;

        boolean pLiesInLST = exists(root.left, p);
        boolean qLiesInLST = exists(root.left, q);

        if (pLiesInLST && qLiesInLST)
            return lowestCommonAncestor(root.left, p, q);

        if (!pLiesInLST && !qLiesInLST)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}


// Time Complexity: O(n^2)
// Space Complexity: O(h)