class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];

        // XOR of all numbers from 1 to n
        int totalXor = 0;

        for (int i = 1; i <= n; i++) {
            totalXor = totalXor ^ i;
        }

        // XOR of perm[1], perm[3], perm[5]...
        int oddXor = 0;

        for (int i = 1; i < encoded.length; i += 2) {
            oddXor = oddXor ^ encoded[i];
        }

        // Find first element
        perm[0] = totalXor ^ oddXor;

        // Find remaining elements
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }

        return perm;
    }
}