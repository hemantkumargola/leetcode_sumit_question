class Solution {
    public int maxSubarraySum(int[] arr, int k) {

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Sliding window
        for (int i = k; i < arr.length; i++) {

            sum += arr[i];
            sum -= arr[i - k];

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}