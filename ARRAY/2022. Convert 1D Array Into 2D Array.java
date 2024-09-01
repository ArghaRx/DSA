// https://leetcode.com/problems/convert-1d-array-into-2d-array/description/


class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int ans[][] = new int[m][n];
        if(m * n != original.length) return new int[0][0];

        int ind = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans[i][j] = original[ind++];
            }
        }
        /*
            Another approach   O(N)

            for(int i=0;i<original.length;i++)
            res[i/n][i%n]=original[i];
        */
        return ans;
    }
}
