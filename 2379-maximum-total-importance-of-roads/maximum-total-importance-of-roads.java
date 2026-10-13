
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        // Count the roads connected to each 
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Sort cities by degree
        java.util.Arrays.sort(degree);

        long ans = 0;

        // Assign values from 1 to n
        for (int i = 0; i < n; i++) {
            ans += degree[i] * (i + 1);
        }

        return ans;
    }
}
