import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        backtrack(num, target, 0, "", 0, 0, ans);
        return ans;
    }

    private void backtrack(String num,
                            int target,
                            int index,
                            String path,
                            long value,
                            long prevNum,
                            List<String> ans) {

        // Base Case: Processed all digits in the string
        if (index == num.length()) {
            if (value == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Skip numbers with leading zeros (e.g., "05", "00")
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            // First number in the expression (no operator prefix)
            if (index == 0) {
                backtrack(num,
                        target,
                        i + 1,
                        currStr,
                        curr,
                        curr,
                        ans);
            } else {
                // Addition (+)
                backtrack(num,
                        target,
                        i + 1,
                        path + "+" + currStr,
                        value + curr,
                        curr,
                        ans);

                // Subtraction (-)
                backtrack(num,
                        target,
                        i + 1,
                        path + "-" + currStr,
                        value - curr,
                        -curr,
                        ans);

                // Multiplication (*)
                backtrack(num,
                        target,
                        i + 1,
                        path + "*" + currStr,
                        value - prevNum + (prevNum * curr),
                        prevNum * curr,
                        ans);
            }
        }
    }
}