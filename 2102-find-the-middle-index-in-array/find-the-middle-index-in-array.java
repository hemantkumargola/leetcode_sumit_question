
class Solution {
    public int findMiddleIndex(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)