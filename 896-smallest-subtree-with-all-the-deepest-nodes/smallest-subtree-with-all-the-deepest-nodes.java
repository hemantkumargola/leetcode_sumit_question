class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }

    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public Pair solve(TreeNode root) {

        if (root == null) {
            return new Pair(null, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }

        else if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        else {
            return new Pair(root, left.depth + 1);
        }
    }
}