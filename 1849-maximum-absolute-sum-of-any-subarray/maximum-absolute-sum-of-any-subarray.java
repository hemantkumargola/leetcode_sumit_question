class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int maxSum = 0;
        int minSum = 0;

        for (int num : nums) {
            curMax = Math.max(0, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(0, curMin + num);
            minSum = Math.min(minSum, curMin);
        }

        return Math.max(maxSum, -minSum);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)