import java.util.*;

class Solution {

    String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public void solve(int index, String digits,
                      StringBuilder ds,
                      List<String> ans) {

        // Base Case
        if (index == digits.length()) {
            ans.add(ds.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            ds.append(letters.charAt(i));

            solve(index + 1, digits, ds, ans);

            ds.deleteCharAt(ds.length() - 1); // Backtrack
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        solve(0, digits, new StringBuilder(), ans);

        return ans;
    }
}