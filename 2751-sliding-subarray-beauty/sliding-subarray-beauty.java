
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[101];

        // First window
        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }

        for (int i = 0; i <= n - k; i++) {
            int count = 0;

            // Find x-th smallest negative number
            for (int j = 0; j < 50; j++) {
                count += freq[j];

                if (count >= x) {
                    ans[i] = j - 50;
                    break;
                }
            }

            // Slide the window
            if (i < n - k) {
                freq[nums[i] + 50]--;
                freq[nums[i + k] + 50]++;
            }
        }

        return ans;
    }
}