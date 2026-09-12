class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // If the starting pixel is already the target color, return immediately
        if (originalColor == color) {
            return image;
        }
        
        dfs(image, sr, sc, originalColor, color);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        
        // If current pixel is not the original color, stop
        if (image[r][c] != originalColor) {
            return;
        }
        
        // Change color
        image[r][c] = newColor;
        
        // Visit 4-directionally adjacent pixels
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }
}