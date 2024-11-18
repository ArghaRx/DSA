   //     https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18


class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0)
            return new int[n];

        int ans[] = new int[n];
        int ind = 0;


        if (k > 0) 
        {

            for (int i = 0; i < n; i++) 
            {
                int temp = k;
                int sum = 0;

                while(k != 0)
                {
                    sum += code[(i + k) % n];
                    k--;
                }
                ans[ind++] = sum;
                k = temp;
            }
        }
        else
        {
            k = -1 * k;
            for(int i = 0; i < n; i++)
            {
                int temp = k;
                int sum = 0;

                while(k != 0)
                {
                    sum += code[(i - k + n) % n];
                    k--;
                }

                ans[ind++] = sum;
                k = temp;
            }
        }

        return ans;
    }
}
