class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2); 
                }
            }
        }

        int maxMinutes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) return -1; 
                if (grid[i][j] >= 2) {
                    maxMinutes = Math.max(maxMinutes, grid[i][j] - 2);
                }
            }
        }
        return maxMinutes;
    }

    private void dfs(int[][] grid, int r, int c, int minutes) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
            grid[r][c] == 0 || (grid[r][c] > 1 && grid[r][c] < minutes)) {
            return;
        }

        grid[r][c] = minutes; 
        for (int[] d : directions) {
            dfs(grid, r + d[0], c + d[1], minutes + 1);
        }
    }
}
