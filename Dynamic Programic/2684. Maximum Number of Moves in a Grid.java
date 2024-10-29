// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/

// Recursion
class Solution {
    int direction[] = {-1, 0, 1};

    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxiStep = 0;
        
        // Try starting from each row in the first column
        for (int i = 0; i < row; i++) {
            maxiStep = Math.max(maxiStep, helper(i, 0, grid, row, col));
        }
        return maxiStep;
    }

    public int helper(int row, int col, int[][] grid, int m, int n) {
        // Base case: if we reach the last column
        if (col == n - 1) return 0;

        int step = 0;

        // Check each direction: right, upper diagonal, and lower diagonal
        for (int dir : direction) {
            int newRow = row + dir;
            int newCol = col + 1;

            // Ensure newRow and newCol are within bounds and cell value is greater
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                step = Math.max(step, 1 + helper(newRow, newCol, grid, m, n));
            }
        }
        return step;
    }
}




// MEMOIZATION

class Solution {
    int direction[] = {-1, 0, 1};

    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxiStep = 0;

         int dp[][] = new int[row + 1][col + 1];
        for(int i[] : dp)
        {
            Arrays.fill(i, -1);
        }
        
        // Try starting from each row in the first column
        for (int i = 0; i < row; i++) {
            maxiStep = Math.max(maxiStep, helper(i, 0, grid, row, col, dp));
        }
        return maxiStep;
    }

    public int helper(int row, int col, int[][] grid, int m, int n, int dp[][]) {
       if (col == n - 1) return 0;
        
        if(dp[row][col] != -1) return dp[row][col];

        int step = 0;

        // Check each direction: right, upper diagonal, and lower diagonal
        for (int dir : direction) {
            int newRow = row + dir;
            int newCol = col + 1;

            // Ensure newRow and newCol are within bounds and cell value is greater
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                step = Math.max(step, 1 + helper(newRow, newCol, grid, m, n, dp));
            }
        }
        return dp[row][col] = step;
    }
}
