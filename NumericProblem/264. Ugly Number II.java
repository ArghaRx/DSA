https://leetcode.com/problems/ugly-number-ii/



class Solution {
    public int nthUglyNumber(int n) {
        int ans[] = new int[n];

        int id2 = 0, id3 = 0, id5 = 0; // Assigh the index
        
        int mulOf2 = 2;
        int mulOf3 = 3;
        int mulOf5 = 5;

        ans[0] = 1;
        for(int i = 1; i < n; i++)
        {
            int mini = Math.min(mulOf2, Math.min(mulOf3, mulOf5));
            ans[i] = mini;

            if(mini == mulOf2)
            {
                id2++;
                mulOf2 = ans[id2] * 2;
                
            }
            if(mini == mulOf3)
            {
                id3++;
                mulOf3 = ans[id3] * 3;
            }
            if(mini == mulOf5)
            {
                id5++;
                mulOf5 = ans[id5] * 5;
            }
        }
        return ans[n - 1];
    }
}