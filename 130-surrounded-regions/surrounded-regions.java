
class Solution {
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Check first and last column
        for (int i = 0; i < rows; i++) {

            if (board[i][0] == 'O') {
                q.add(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][cols - 1] == 'O') {
                q.add(new int[]{i, cols - 1});
                board[i][cols - 1] = '#';
            }
        }

        // Step 2: Check first and last row
        for (int j = 0; j < cols; j++) {

            if (board[0][j] == 'O') {
                q.add(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[rows - 1][j] == 'O') {
                q.add(new int[]{rows - 1, j});
                board[rows - 1][j] = '#';
            }
        }

        // Step 3: BFS
        int[][] directions = {
            {-1, 0},  // Up
            {1, 0},   // Down
            {0, -1},  // Left
            {0, 1}    // Right
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // Step 4: Convert remaining O to X
        // Convert # back to O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

// Time Complexity: O(rows * cols)
// Space Complexity: O(rows * cols)
