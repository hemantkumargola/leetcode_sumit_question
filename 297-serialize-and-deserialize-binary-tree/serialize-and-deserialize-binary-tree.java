import java.util.*;

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    int index;

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;

        return build(arr);
    }

    private TreeNode build(String[] arr) {

        if (arr[index].equals("#")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)