class Solution {
    public String convert(String s, int numRows) {

        // Edge case
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Har row ke liye StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = true;

        for (char ch : s.toCharArray()) {

            // Character ko current row me add karo
            rows[row].append(ch);

            // Direction change
            if (row == 0) {
                down = true;
            } else if (row == numRows - 1) {
                down = false;
            }

            // Row change
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        // Sabhi rows ko combine karo
        StringBuilder ans = new StringBuilder();

        for (StringBuilder r : rows) {
            ans.append(r);
        }

        return ans.toString();
    }
}