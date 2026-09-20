class Solution {
    public int reverseDegree(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Reverse alphabet position
            int reverseValue = 26 - (ch - 'a');

            // String position = i + 1
            ans += reverseValue * (i + 1);
        }

        return ans;
    }
}