class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);

            if (root.left != null) {
                leaves.add(root.left.val);
            }

            if (root.right != null) {
                leaves.add(root.right.val);
            }
        }

        TreeNode root = null;

        for (TreeNode node : trees) {
            if (!leaves.contains(node.val)) {
                if (root != null) return null;
                root = node;
            }
        }

        if (root == null) return null;

        map.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE, map)) {
            return null;
        }

        if (!map.isEmpty()) return null;

        return root;
    }

    public boolean dfs(TreeNode root, long min, long max,
                       Map<Integer, TreeNode> map) {

        if (root == null) return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (root.left == null && root.right == null) {
            TreeNode node = map.remove(root.val);

            if (node != null) {
                root.left = node.left;
                root.right = node.right;
            }
        }

        return dfs(root.left, min, root.val, map)
            && dfs(root.right, root.val, max, map);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)