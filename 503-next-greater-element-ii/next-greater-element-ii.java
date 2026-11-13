
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice (Circular Array)
        for (int i = 2 * n - 1; i >= 0; i--) {

            int num = nums[i % n];

            // Remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // Store answer only during first traversal
            if (i < n && !stack.isEmpty()) {
                ans[i] = stack.peek();
            }

            // Push current element
            stack.push(num);
        }

        return ans;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)