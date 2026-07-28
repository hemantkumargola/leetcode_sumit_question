class Solution {

    public double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return power(x, power);
    }

    private double power(double x, long n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // Recursive Call
        double half = power(x, n / 2);

        // Even Power
        if (n % 2 == 0) {
            return half * half;
        }

        // Odd Power
        return x * half * half;
    }
}
// | Complexity           | Value        |
// | -------------------- | ------------ |
// | **Time Complexity**  | **O(log n)** |
// | **Space Complexity** | **O(1)**     |
