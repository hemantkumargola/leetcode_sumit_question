
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> curr) {

        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {

            curr.add(nums[i]);              // Choose

            backtrack(i + 1, nums, curr);   // Explore

            curr.remove(curr.size() - 1);   // Backtrack
        }
    }
}



// Time Complexity: O(n × 2ⁿ)
// Auxiliary Space: O(n) (recursion stack + current subset)
// Output Space: O(n × 2ⁿ) (to store all subsets)