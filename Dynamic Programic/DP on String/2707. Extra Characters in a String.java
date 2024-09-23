**********************************    RECURSION + Memo  *********************************************************

//Approach-1 (Recursion + Memo)
//T.C : O(n^3)
//S.C : O(total numberof characters in dictionary words + n for memoization array)
// Approach-1 (Recursion + Memoization)
// T.C : O(n^3)
// S.C : O(total number of characters in dictionary words + n for memoization array)

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        return solve(0, n, s, set);
    }

    public int solve(int i, int n, String s, Set<String> set)
    {
        if(i >= n) return 0;

        // Take ist char as extra char and solve the remaining part
        int result = 1 + solve(i + 1, n, s, set);

        // or i take substring part and chech either it present in set or not
        for(int j = i; j < s.length(); j++)
        {
            String str = s.substring(i, j + 1); // substring

            // if contins in set
    // check the older result or current willing result, which extra xhar comes minimum
            if(set.contains(str))
            {
                result = Math.min(result, solve(j + 1, n, s, set));
            }
        }
        return result;
    }
}


********************************  TABULATION  **********************************************************

//Approach-2 (Bottom Up)
//T.C : O(n^3)
//S.C : O(n)
// Approach-2 (Bottom-Up)
// T.C : O(n^3)
// S.C : O(n)




class Solution {

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();

        int dp[] = new int[n + 1];


        for(int i = n - 1; i >= 0; i--)
        {
            // Take ist char as extra char and solve the remaining part
            dp[i] = 1 + dp[i + 1];

            // or i take substring part and chech either it present in set or not
            for(int j = i; j < s.length(); j++)
            {
                String str = s.substring(i, j + 1); // substring

                // if contins in set
        // check the older result or current willing result, which extra xhar comes minimum
                if(set.contains(str))
                {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }

        }
        
        return dp[0];
    }
}
