class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int target = n * n;

        boolean[] visited = new boolean[target + 1];

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                if (curr == target) {
                    return moves;
                }

                for (int dice = 1; dice <= 6; dice++) {

                    int next = curr + dice;

                    if (next > target) {
                        break;
                    }

                    int[] pos = getPosition(next, n);

                    int r = pos[0];
                    int c = pos[1];

                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public int[] getPosition(int num, int n) {

        int row = (num - 1) / n;
        int col = (num - 1) % n;

        int r = n - 1 - row;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{r, col};
    }
}

// Time Complexity: \(O(N^2)\)
// Space Complexity: \(O(N^2)\)