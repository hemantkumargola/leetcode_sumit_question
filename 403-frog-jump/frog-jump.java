
import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (stones[1] != 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[n][n + 1];

        return solve(1, 1, stones, map, dp);
    }

    private boolean solve(int index, int lastJump, int[] stones,
                          Map<Integer, Integer> map, Boolean[][] dp) {

        if (index == stones.length - 1) {
            return true;
        }

        if (dp[index][lastJump] != null) {
            return dp[index][lastJump];
        }

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) {
                continue;
            }

            int nextPosition = stones[index] + jump;

            if (map.containsKey(nextPosition)) {
                int nextIndex = map.get(nextPosition);

                if (solve(nextIndex, jump, stones, map, dp)) {
                    return dp[index][lastJump] = true;
                }
            }
        }

        return dp[index][lastJump] = false;
    }
}
