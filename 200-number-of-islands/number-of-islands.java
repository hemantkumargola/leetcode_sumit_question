class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Land found
                if (grid[i][j] == '1') {

                    count++;

                    // BFS  hota hai 
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});

                    // Mark visited
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {

                        int[] curr = q.poll();

                        int r = curr[0];
                        int c = curr[1];

                        // Up
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '0';
                            q.add(new int[]{r - 1, c});
                        }

                        // Down
                        if (r + 1 < rows && grid[r + 1][c] == '1') {
                            grid[r + 1][c] = '0';
                            q.add(new int[]{r + 1, c});
                        }

                        // Left
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '0';
                            q.add(new int[]{r, c - 1});
                        }

                        // Right
                        if (c + 1 < cols && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '0';
                            q.add(new int[]{r, c + 1});
                        }
                    }
                }
            }
        }

        return count;
    }
}