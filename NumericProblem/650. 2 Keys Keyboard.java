// https://leetcode.com/problems/2-keys-keyboard/description/

// Sol = https://leetcode.com/problems/2-keys-keyboard/solutions/5657975/98-33-easy-solution-with-ultimate-explanation

class Solution {
    public int minSteps(int n) {
        // Base case
        if (n == 1)
            return 0;

        int steps = 0;
        int factor = 2;

        while (n > 1) 
        {
            while (n % factor == 0) 
            {
                steps += factor;
                n /= factor;
            }
            factor += 1;
        }
        return steps;
    }
}
