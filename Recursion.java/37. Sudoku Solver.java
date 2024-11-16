

class Solution {
    public boolean solveSudoku(char[][] board) {
        // Find the first null value
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) {
                                return true;  // Return true if the board is solved
                            } else {
                                board[i][j] = '.';  // Backtrack if the solution is not valid
                            }
                        }
                    }
                    return false;  // Return false if no valid solution is found for the current empty cell
                }
            }
        }
        return true;  // Return true if the entire board is filled
    }

    public boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++)
        {
          
            if(board[row][i] == c) return false;

            if(board[i][col] == c) return false;

            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) return false;
        }
        return true;
    }
}
