import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        // Prefix Sum
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(nums, queries[i]);
        }

        return ans;
    }

    private int binarySearch(int[] prefix, int target) {

        int low = 0;
        int high = prefix.length - 1;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (prefix[mid] <= target) {
                ans = mid + 1;   // Number of elements
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}