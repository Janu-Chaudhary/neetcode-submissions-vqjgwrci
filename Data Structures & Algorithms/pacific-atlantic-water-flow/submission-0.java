

class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // Check every single cell one by one
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // ocean[0] tracks Pacific, ocean[1] tracks Atlantic
                boolean[] ocean = new boolean[2]; 
                // Track cells visited during THIS specific cell's search
                boolean[][] visited = new boolean[rows][cols]; 
                
                dfs(heights, i, j, ocean, visited); 
                
                // If this starting cell managed to touch both oceans
                if (ocean[0] && ocean[1]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int r, int c, boolean[] ocean, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 1. Check if we went past the Pacific boundaries (Top or Left)
        if (r < 0 || c < 0) {
            ocean[0] = true;
            return;
        }
        // 2. Check if we went past the Atlantic boundaries (Bottom or Right)
        if (r >= rows || c >= cols) {
            ocean[1] = true;
            return;
        }
        
        // 3. If already visited in this path, stop to prevent infinite loops
        if (visited[r][c]) {
            return;
        }

        // Mark the current cell as visited
        visited[r][c] = true;

        // Look at all 4 neighbors
        for (int[] d : directions) {
            int nextR = r + d[0];
            int nextC = c + d[1];

            // If the neighbor is an ocean boundary OR if it is equal/lower height, we can flow there
            if (nextR < 0 || nextC < 0 || nextR >= rows || nextC >= cols || grid[r][c] >= grid[nextR][nextC]) {
                dfs(grid, nextR, nextC, ocean, visited);
            }
        }
        
        // Backtrack: unmark visited so other alternative paths can utilize this cell
        visited[r][c] = false;
    }
}
