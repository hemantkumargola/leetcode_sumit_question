class Solution {
    int idx = 0;

    public TreeNode build(int[] preorder, int min, int max) {

        if (idx == preorder.length) {
            return null;
        }

        int val = preorder[idx];

        if (val < min || val > max) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        idx++;

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}


// Time Complexity: O(n)
// Space Complexity: O(h)
// Worst Case Space: O(n)