class Solution {
    Set<String> visited = new HashSet<>();
    boolean isFound = false;

    public boolean exist(char[][] board, String word) {
        int rowL = board.length;
        int colL = board[0].length;
        
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                wordSearch("", board, word, new int[]{i, j}, rowL, colL, "None");
                if (isFound) return true;
            }
        }
        return isFound;
    }

    void wordSearch(String current, char[][] board, String word, int[] index, int rowL, int colL, String direction) {
        int r = index[0];
        int c = index[1];

        if (r < 0 || r >= rowL || c < 0 || c >= colL || isFound) return;
        if (board[r][c] != word.charAt(current.length())) return;

        String pos = r + "," + c;
        if (visited.contains(pos)) return;

        current = current + board[r][c];

        if (current.equals(word)) {
            isFound = true;
            return;
        }

        visited.add(pos);


        // Forward (Right)
        index[1] += 1; 
        wordSearch(current, board, word, index, rowL, colL, "Forward");
        index[1] -= 1;

        // Backward (Left)
        index[1] -= 1;  
        wordSearch(current, board, word, index, rowL, colL, "Backward");
        index[1] += 1;
        // Downward
        index[0] += 1; 
        wordSearch(current, board, word, index, rowL, colL, "Downward");
        index[0] -= 1;
        // Upward
        index[0] -= 1; 
        wordSearch(current, board, word, index, rowL, colL, "Upward");
        index[0] += 1;

        visited.remove(pos);
    }
}
