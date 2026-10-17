class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int zeros = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}

/*Time Complexity:  O(n)
Space Complexity: O(1) */