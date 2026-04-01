class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
       if (grid == null || grid.length == 0) return 0;

        int rowsLength = grid.length;   
        int colLength = grid[0].length; 
        int landArea = 0;

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < colLength; j++) { 
                if (grid[i][j] == 1) {
                    int[] area = {0};
                    dfs(grid, rowsLength, colLength, i, j,area);
                    landArea = Math.max(landArea, area[0]);
                }
            }
        }
        return landArea; 
    } 

    public void dfs(int[][] grid, int rowsLength, int colLength, int r, int c, int[] area) {
        if (r < 0 || c < 0 || r >= rowsLength || c >= colLength || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0; 
        area[0] = area[0]+1;
        for (int[] direction : directions) {
            dfs(grid, rowsLength, colLength, r + direction[0], c + direction[1],area);
        }
    }
}
  
    

