
class Solution {
    private void invert(TreeNode root){
        if(root == null) return ;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);




    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
        
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree