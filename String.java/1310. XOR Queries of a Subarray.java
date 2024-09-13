
//https://leetcode.com/problems/xor-queries-of-a-subarray/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int ans[] = new int[queries.length];
        int ind = 0;

        int row = queries.length;
        for(int i = 0; i < row; i++)
        {
                int ist = queries[i][0];
                int sec = queries[i][1];
                int xor = 0;
                for(int j = ist; j <= sec; j++)
                {
                    xor ^= arr[j];
                }
            ans[ind++] = xor;
        }
        return ans;
    }
}