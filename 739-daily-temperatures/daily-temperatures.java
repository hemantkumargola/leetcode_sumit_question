
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller or equal temperatures
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            // Calculate days to wait
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }

            // Push current index
            st.push(i);
        }

        return ans;
    }
}
