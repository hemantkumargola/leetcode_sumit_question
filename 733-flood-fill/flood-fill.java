
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If color is already the same, return image
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int originalColor, int color) {
        int m = image.length;
        int n = image[0].length;

        // Boundary check
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }

        // Stop if pixel has a different color
        if (image[r][c] != originalColor) {
            return;
        }

        // Change the current pixel's color
        image[r][c] = color;

        // Visit four directions
        dfs(image, r + 1, c, originalColor, color); // Down
        dfs(image, r - 1, c, originalColor, color); // Up
        dfs(image, r, c + 1, originalColor, color); // Right
        dfs(image, r, c - 1, originalColor, color); // Left
    }
}
