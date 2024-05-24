/*  // https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/


// Recursive 
// TC - O(2 ^ N)     SC - O(N)

class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}


// Memoization
// TC - O(N)     SC - O(N)


class Solution {
    public int climbStairs(int n) {

	//CREATE A DP[] ARRAY
        int dp[] = new int[n + 1];

	// FILL BY -1
        Arrays.fill(dp, -1);

        if(n == 0) return 1;
        if(n == 1) return 1;

	// IF VALUE ALREADY PRESENT OR FIND PREVIOUS, THEN RETURN IT
        if(dp[n] != -1) return dp[n];

	// RETURN BUT STORE THE VALUE IN DP[IND]
        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}


// Tabulation
// TC - O(N)     SC - O(N)

class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
       for(int i = 2; i <= n; i++)
       dp[i] = dp[i - 1] + dp[i - 2];

       return dp[n];
    }
}



// Space Optimization
// TC - O(N)     SC - O(1)

class Solution {
    public int climbStairs(int n) {

        int prev2 = 1;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev2 + prev;
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}