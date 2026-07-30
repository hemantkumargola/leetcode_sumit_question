import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);

        return ans;
    }

    private void solve(int col,
                       char[][] board,
                       List<List<String>> ans,
                       int[] leftRow,
                       int[] upperDiagonal,
                       int[] lowerDiagonal,
                       int n) {

        // Base Case
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {

            if (leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0) {

                // Place Queen
                board[row][col] = 'Q';

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, ans,
                        leftRow, upperDiagonal,
                        lowerDiagonal, n);

                // Backtrack
                board[row][col] = '.';

                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    private List<String> construct(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board)
            list.add(new String(row));

        return list;
    }
}