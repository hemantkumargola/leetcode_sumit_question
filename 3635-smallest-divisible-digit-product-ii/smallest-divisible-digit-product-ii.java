import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t into 2, 3, 5, 7
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        
        long tempT = t;
        while (tempT % 2 == 0) { c2++; tempT /= 2; }
        while (tempT % 3 == 0) { c3++; tempT /= 3; }
        while (tempT % 5 == 0) { c5++; tempT /= 5; }
        while (tempT % 7 == 0) { c7++; tempT /= 7; }
        
        // If t has prime factors > 7, it's impossible
        if (tempT > 1) return "-1";

        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
        }

        // Try to find a valid string of length `n`
        String ans = solveSameLength(digits, c2, c3, c5, c7);
        if (ans != null) return ans;

        // If impossible with length `n`, find the minimal string with length > `n`
        return solveGreaterLength(n + 1, c2, c3, c5, c7);
    }

    private String solveSameLength(int[] num, int c2, int c3, int c5, int c7) {
        int n = num.length;
        int[] prefix2 = new int[n + 1];
        int[] prefix3 = new int[n + 1];
        int[] prefix5 = new int[n + 1];
        int[] prefix7 = new int[n + 1];

        // Find first occurrence of '0' if any
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (num[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        // Compute factor counts of matching prefix
        for (int i = 0; i < n; i++) {
            if (num[i] == 0) break;
            prefix2[i + 1] = prefix2[i] + getFactor(num[i], 2);
            prefix3[i + 1] = prefix3[i] + getFactor(num[i], 3);
            prefix5[i + 1] = prefix5[i] + getFactor(num[i], 5);
            prefix7[i + 1] = prefix7[i] + getFactor(num[i], 7);
        }

        // Try matching prefix of length `i`
        int limit = (zeroIdx != -1) ? zeroIdx : n;

        // Try exact match first if no zeros present
        if (zeroIdx == -1) {
            if (prefix2[n] >= c2 && prefix3[n] >= c3 && prefix5[n] >= c5 && prefix7[n] >= c7) {
                StringBuilder sb = new StringBuilder();
                for (int d : num) sb.append(d);
                return sb.toString();
            }
        }

        // Backtrack from right to left to find pivot digit to increment
        for (int i = limit; i >= 0; i--) {
            int rem2 = Math.max(0, c2 - prefix2[i]);
            int rem3 = Math.max(0, c3 - prefix3[i]);
            int rem5 = Math.max(0, c5 - prefix5[i]);
            int rem7 = Math.max(0, c7 - prefix7[i]);

            int startDigit = (i < n) ? num[i] + 1 : 1;
            for (int d = startDigit; d <= 9; d++) {
                int r2 = Math.max(0, rem2 - getFactor(d, 2));
                int r3 = Math.max(0, rem3 - getFactor(d, 3));
                int r5 = Math.max(0, rem5 - getFactor(d, 5));
                int r7 = Math.max(0, rem7 - getFactor(d, 7));

                int remLen = n - 1 - i;
                String suffix = getMinimalSuffix(remLen, r2, r3, r5, r7);
                if (suffix != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < i; j++) sb.append(num[j]);
                    sb.append(d);
                    sb.append(suffix);
                    return sb.toString();
                }
            }
        }
        return null;
    }

    private String solveGreaterLength(int minLen, int c2, int c3, int c5, int c7) {
        int len = minLen;
        while (true) {
            String suffix = getMinimalSuffix(len, c2, c3, c5, c7);
            if (suffix != null) return suffix;
            len++;
        }
    }

    // Greedily constructs the smallest suffix of given `len` satisfying required factors
    private String getMinimalSuffix(int len, int r2, int r3, int r5, int r7) {
        // We pack prime factors into largest possible digits (9, 8, 7, 6, 5, 4, 3, 2)
        int count9 = r3 / 2;
        r3 %= 2;
        int count8 = r2 / 3;
        r2 %= 3;

        int count7 = r7;
        int count5 = r5;

        int count6 = 0;
        if (r2 > 0 && r3 > 0) {
            count6 = 1;
            r2--;
            r3--;
        }

        int count4 = r2 / 2;
        r2 %= 2;

        int count3 = r3;
        int count2 = r2;

        int totalDigits = count9 + count8 + count7 + count6 + count5 + count4 + count3 + count2;
        if (totalDigits > len) return null;

        int ones = len - totalDigits;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ones; i++) sb.append('1');
        for (int i = 0; i < count2; i++) sb.append('2');
        for (int i = 0; i < count3; i++) sb.append('3');
        for (int i = 0; i < count4; i++) sb.append('4');
        for (int i = 0; i < count5; i++) sb.append('5');
        for (int i = 0; i < count6; i++) sb.append('6');
        for (int i = 0; i < count7; i++) sb.append('7');
        for (int i = 0; i < count8; i++) sb.append('8');
        for (int i = 0; i < count9; i++) sb.append('9');

        return sb.toString();
    }

    private int getFactor(int d, int prime) {
        if (d == 0) return 0;
        int count = 0;
        while (d % prime == 0) {
            count++;
            d /= prime;
        }
        return count;
    }
}