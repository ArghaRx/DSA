class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];

        for (int[] guard : guards) {
        int i = guard[0];
        int j = guard[1];
        grid[i][j] = 2; // mark guards
        }


        /*
    IMP:-
        To access the guards or walls array, if i use normal loop, then i just iterate the gurards loop,
        It gives 0,0  0,1 0,2    1,0  1,1  1,2    2,0  2,1  2,2
        
        But we needs the value which have in guards array, That's why we should use for-each loop
        to access guard or wall array

        
        for(int i = 0; i < walls.length; i++)
        {
            for(int j = 0; j < walls[0].length; j++)
            {
                grid[i][j] = 3; // mark walls
            }
        }
        */

        // using for each loop
        for(int wall[] : walls)
        {
            int i = wall[0];
            int j = wall[1];

            grid[i][j] = 3; // mark walls
        }

        // Mark cells guarded by each guard
        for(int guard[] : guards)
        {
            int i = guard[0];
            int j = guard[1];

            markGrid(i, j, grid);
        }


        int count = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0) count++;
            }
        }

        return count;
    }


    public void markGrid(int row, int col, int grid[][])
    {
        // up
        for(int i = row - 1; i >= 0; i--)
        {
            if(grid[i][col] == 2 || grid[i][col] == 3)
            {
                break;
            }
            else
            {
                grid[i][col] = 1;
            }
        }

        // down
        for(int i = row + 1; i < grid.length; i++)
        {
            if(grid[i][col] == 2 || grid[i][col] == 3)
            {
                break;
            }
            else
            {
                grid[i][col] = 1;
            }
        }


        // left
        for(int i = col - 1; i >= 0; i--)
        {
            if(grid[row][i] == 2 || grid[row][i] == 3) break;

            else grid[row][i] = 1;
        }

        // right
        for(int i = col + 1; i < grid[0].length; i++)
        {
            if(grid[row][i] == 2 || grid[row][i] == 3) break;
            
            else grid[row][i] = 1;
        }
    }
}
