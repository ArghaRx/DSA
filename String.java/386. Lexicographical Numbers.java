// https://leetcode.com/problems/lexicographical-numbers/description/

//Approach (Simple Recursion - DFS)
//T.C : O(n) - We visit each number (1 to n) only once.
//S.C : O(d) - where d is the number of digits in n i.e. log10(n)


class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        // Always Start from numbers 1 to 9
        for(int startNum = 1; startNum <= 9; startNum++)
        {
            solve(startNum, n, result);
        }
        return result;
    }

    public void solve(int curr, int n, List<Integer> result)
    {
        if(curr > n) return;

        result.add(curr);  // Add current number to result

        // Generate the next number by appending digits 0 to 9
        for(int nextNum = 0; nextNum <= 9; nextNum++)
        {
            int nowDigit = (curr * 10) + nextNum;

            if(nowDigit > n) return;
            
            // Recursive call
            solve(nowDigit, n, result);
        }
    }
}
