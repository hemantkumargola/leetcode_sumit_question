
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count tasks having maximum frequency
        int count = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                count++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + count;

        return Math.max(tasks.length, result);
    }
}
