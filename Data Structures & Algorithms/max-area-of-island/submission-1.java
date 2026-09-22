class Solution {

    // The directions must be in solution class so it available for all
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {

        // rowLen is number of rows and i represents it in traversal
        int rowLen = grid.length;

        // colLen is number of columns and j represents it.
        int colLen = grid[0].length;




        int landarea = 0;

        //  Traverse the whole graph 
        for (int i = 0; i < rowLen; i++){
            for (int j = 0; j < colLen; j++){

                // work only on required cell only
                if (grid[i][j] == 1){
                    int[] area = {0};

                    // travserse
                    traverse(i,j, rowLen, colLen, area, grid);
                    landarea = Math.max(landarea, area[0]);

                }


            }
        }

        return landarea;
        
    }

    public void traverse( int i, int j, int rowLen, int colLen, int[] area, int[][] grid){

        // be aware while writing the conditions i < 0 is top case || i>=i is bottom case 
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] == 0){
            return;

        }

        // perform the actions 
        area[0] += 1;
        grid[i][j] = 0;

        // traverse in neighbouring
        for (int[] direction: directions){
            traverse(i+direction[0], j+direction[1],rowLen, colLen, area, grid);
        }
    }
}
