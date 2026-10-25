class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.add(node.left))
                    queue.offer(node.left);

                if (node.right != null && visited.add(node.right))
                    queue.offer(node.right);

                TreeNode p = parent.get(node);
                if (p != null && visited.add(p))
                    queue.offer(p);
            }

            distance++;
        }

        return result;
    }

    private void findParent(TreeNode node, TreeNode p) {
        if (node == null) return;

        parent.put(node, p);
        findParent(node.left, node);
        findParent(node.right, node);
    }
}

// Time: O(N) |
//  Space: O(N)
