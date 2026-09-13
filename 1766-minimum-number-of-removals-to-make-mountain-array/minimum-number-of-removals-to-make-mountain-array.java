class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // LIS ending at i
        for (int i = 0; i < n; i++) {
            left[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        // LDS starting from i
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;

            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int maxMountain = 0;

        for (int i = 1; i < n - 1; i++) {

            // i must be the peak
            if (left[i] > 1 && right[i] > 1) {
                maxMountain = Math.max(
                    maxMountain,
                    left[i] + right[i] - 1
                );
            }
        }

        return n - maxMountain;
    }
}