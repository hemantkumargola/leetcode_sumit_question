class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        int n = s.length;
        int m = t.length;

        // dp[i] = maximum suffix length of word2 that can be matched
        // using word1 starting from index i.
        int[] dp = new int[n + 1];

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && s[i] == t[j]) {
                dp[i] = dp[i + 1] + 1;
                j--;
            } else {
                dp[i] = dp[i + 1];
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Build answer greedily
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                ans[j] = i;
                j++;
            } else {
                // Use the single allowed mismatch
                if (dp[i + 1] >= m - j - 1) {
                    ans[j] = i;
                    j++;
                    i++;
                    break;
                }
            }
            i++;
        }

        if (j < m && i == n) {
            return new int[0];
        }

        // Match the remaining characters exactly
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                ans[j] = i;
                j++;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}