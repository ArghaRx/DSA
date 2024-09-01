// https://leetcode.com/problems/reshape-the-matrix/description/


class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
    int ans[][] = new int[r][c];
    int m = mat.length;
    int n = mat[0].length;
     // Check if reshaping is possible
        if (r * c != m * n) {
            return mat;  // Return the original matrix if reshaping isn't possible
        }

    int ind = 0;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            ans[ind / c][ind % c] = mat[i][j];
            ind++;
        }
    }
       return ans;
    }
}
