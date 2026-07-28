class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if (s.length() == 0)
            return 0;

        char start = s.charAt(0);

        int sign = 1;
        int idx = 0;

        if (start == '-') {
            sign = -1;
            idx = 1;
        } else if (start == '+') {
            idx = 1;
        }

        long result = 0;

        for (int i = idx; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {

                result = result * 10 + (c - '0');

                if (result * sign >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

                if (result * sign <= Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;

            } else {
                break;
            }
        }

        return (int) (result * sign);
    }
}


// Interview Answer
// Time Complexity: O(n)
// Space Complexity: O(n) (due to trim())
// Without trim(): O(1) extra space, which is the optimal solution.