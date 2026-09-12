class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }
// again
        return (n & (n - 1)) == 0;
    }
}