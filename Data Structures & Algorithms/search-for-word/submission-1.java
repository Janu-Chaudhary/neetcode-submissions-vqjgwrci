class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Start a DFS if the first letter matches
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // 1. Success base case: Found all letters
        if (index == word.length()) return true;

        // 2. Failure base cases: Out of bounds or wrong letter
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(index)) {
            return false;
        }

        // 3. Mark as visited (like turning '1' to '0' in Islands)
        char temp = board[r][c];
        board[r][c] = '#'; // Use a special character to hide it

        // 4. Explore all 4 directions (The "Search")
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        // 5. BACKTRACK: Restore the letter so other paths can use it
        board[r][c] = temp;

        return found;
    }
}