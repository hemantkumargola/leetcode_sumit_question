class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        // Find invalid parentheses
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {

                if (!stack.isEmpty()) {
                    stack.pop();
                } 
                else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        // Remove unmatched '('
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.setCharAt(index, '*');
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }
}