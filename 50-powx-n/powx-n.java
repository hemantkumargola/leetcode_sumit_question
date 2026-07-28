// class Solution {

//     public double myPow(double x, int n) {

//         if (n >= 0) {
//             return qpow(x, (long) n);
//         } else {
//             return 1 / qpow(x, -(long) n);
//         }
//     }

//     private double qpow(double a, long n) {

//         double ans = 1;

//         while (n > 0) {

//             if ((n & 1) == 1) {
//                 ans = ans * a;
//             }

//             a = a * a;
//             n = n / 2;      // or n >>= 1;
//         }

//         return ans;
//     }
// }
class Solution {

    public double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1;

        while (power > 0) {

            if (power % 2 == 1) {
                ans *= x;
            }

            x *= x;
            power /= 2;
        }

        return ans;
    }
}

// | Complexity           | Value        |
// | -------------------- | ------------ |
// | **Time Complexity**  | **O(log n)** |
// | **Space Complexity** | **O(1)**     |
