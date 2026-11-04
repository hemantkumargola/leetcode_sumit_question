class Solution {

    // Helper function
    public boolean isPossible(int C, int[] arr, int D) {
        int load = 0;
        int days = 1;

        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] <= C) {
                load += arr[i];
            } else {
                days++;
                load = arr[i];
            }
        }
        return days <= D;
    }

    public int shipWithinDays(int[] arr, int D) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int w : arr) {
            max = Math.max(max, w);
            sum += w;
        }

        int lo = max;
        int hi = sum;
        int ans = sum;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(mid, arr, D)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
// Time Complexity: O(n * log(sum))
// Space Complexity: O(1)