
class Solution {
    private void inorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
   int n = ans.size();

      for(int i =0;i<n-1;i++){
        for(int j = i+1;j<n;j++){
        if(ans.get(i) + ans.get(j)==k){
            return true ;
        }
     
      }
    }
    return false;
}
}
// Time Complexity: O(n²)
// Space Complexity: O(n)