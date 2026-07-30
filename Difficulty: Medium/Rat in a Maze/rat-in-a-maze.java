import java.util.*;

class Solution {

    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        // If starting cell is blocked
        if (maze[0][0] == 0) {
            return ans;
        }

        boolean[][] vis = new boolean[n][n];

        solve(0, 0, maze, vis, "", ans);

        Collections.sort(ans);
        return ans;
    }

    private void solve(int i, int j, int[][] maze,
                       boolean[][] vis,
                       String path,
                       ArrayList<String> ans) {

        int n = maze.length;

        // Destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        vis[i][j] = true;

        // Down
        if (isSafe(i + 1, j, maze, vis))
            solve(i + 1, j, maze, vis, path + "D", ans);

        // Left
        if (isSafe(i, j - 1, maze, vis))
            solve(i, j - 1, maze, vis, path + "L", ans);

        // Right
        if (isSafe(i, j + 1, maze, vis))
            solve(i, j + 1, maze, vis, path + "R", ans);

        // Up
        if (isSafe(i - 1, j, maze, vis))
            solve(i - 1, j, maze, vis, path + "U", ans);

        // Backtrack
        vis[i][j] = false;
    }

    private boolean isSafe(int i, int j,
                           int[][] maze,
                           boolean[][] vis) {

        int n = maze.length;

        return (i >= 0 &&
                j >= 0 &&
                i < n &&
                j < n &&
                maze[i][j] == 1 &&
                !vis[i][j]);
    }
}