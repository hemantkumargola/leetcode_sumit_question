import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, String s,
                           List<String> path,
                           List<List<String>> ans) {

        // Base Case
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible partition
        for (int end = index; end < s.length(); end++) {

            if (isPalindrome(s, index, end)) {

                // Pick
                path.add(s.substring(index, end + 1));

                backtrack(end + 1, s, path, ans);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}