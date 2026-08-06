class Solution {

    // Function to calculate product of digits
    public int digitProduct(int num) {

        int product = 1;

        while (num > 0) {
            product *= (num % 10);   // last digit multiply
            num /= 10;               // remove last digit
        }

        return product;
    }

    public int smallestNumber(int n, int t) {

        while (true) {

            int product = digitProduct(n);

            // Check divisibility
            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}