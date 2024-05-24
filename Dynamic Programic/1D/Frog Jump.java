There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example :

Sample Input 1:
2

4
10 20 30 10

3
10 50 10

Sample Output 1:
20
0



// Recursion
// TC - O(N)  SC - O(N +  

import java.util.* ;
import java.io.*; 
public class Solution {
     public static int frogJump(int n, int heights[]) {
        // Write your code here..
        return helper(n - 1, heights);
    }

    public static int helper(int ind, int heights[]) {
        if (ind == 0) {
            return 0;
        }
	//ONESTEP
        int one = helper(ind - 1, heights) + Math.abs(heights[ind] - heights[ind - 1]);

        int two = Integer.MAX_VALUE;
        if (ind > 1) {
	    // TWOSTEP
            two = helper(ind - 2, heights) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return Math.min(one, two);
    }

}




// Memoization
// TC - O(N)  SC - O(N + N)

import java.util.* ;
import java.io.*; 
public class Solution {
     public static int frogJump(int n, int heights[]) {
        // Write your code here..
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, heights, dp);
    }

    public static int helper(int ind, int heights[], int dp[]) {
        if (ind == 0) {
            return 0;
        }
        if(dp[ind] != -1) return dp[ind];

        int one = helper(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);

        int two = Integer.MAX_VALUE;
        if (ind > 1) {
            two = helper(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }two

        return dp[ind] = Math.min(one, two);
    }

}



//Tabulation
// TC - O(N)  SC - O(N)


import java.util.* ;
import java.io.*; 
public class Solution {
     public static int frogJump(int n, int height[]) {
        // Write your code here..
        int dp[] = new int[n];
        
        dp[0] = 0;

         for(int ind = 1; ind < n; ind++){
	// ONESTEP
         int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);
	  
	// TWOSTEP
         int jumpTwo = Integer.MAX_VALUE;
         if(ind > 1)
            jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind-2]);
	
	// AT THAT PARTICULAT DP[IND] STORE THE MINIMUM VALUE    
         dp[ind] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n - 1];
    }

}



// Space Optimization
TC- O(N)  SC - O(1)

import java.util.* ;
import java.io.*; 
public class Solution {
     public static int frogJump(int n, int height[]) {
        // Write your code here..
       
        int prev = 0;
        int prev2 = 0;
         for(int ind = 1; ind < n; ind++){

         int jumpOne = prev + Math.abs(height[ind] - height[ind - 1]);
         int jumpTwo = Integer.MAX_VALUE;
         if(ind > 1)
            jumpTwo = prev2 + Math.abs(height[ind] - height[ind-2]);
    
         int curr = Math.min(jumpOne, jumpTwo);
         prev2 = prev;
         prev = curr;
        }
        return prev;
    }

}