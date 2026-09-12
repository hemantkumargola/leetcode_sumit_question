class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // XOR of all numbers
        for (int n : nums) {
            xor = xor ^ n;
        }

        // Get rightmost set bit
        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        // Divide numbers into two groups
        for (int n : nums) {

            if ((n & bit) != 0) {
                a = a ^ n;
            } else {
                b = b ^ n;
            }
        }

        return new int[]{a, b};
    }
}