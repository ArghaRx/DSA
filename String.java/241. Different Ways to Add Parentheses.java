// https://leetcode.com/problems/different-ways-to-add-parentheses/description/
//   ------------------- Approah 1 ---------------------------------
/*
  Recursive Approach:
  Time Complexity: O(4^n / sqrt(n))
  Space Complexity: O(4^n / sqrt(n))
  
  */
  -----------------------------------------------------
  
import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftSubTree = diffWaysToCompute(left);
                List<Integer> rightSubTree = diffWaysToCompute(right);

                for (int x : leftSubTree) {
                    for (int y : rightSubTree) {
                        if (ch == '+') {
                            ans.add(x + y);
                        } else if (ch == '-') {
                            ans.add(x - y);
                        } else if (ch == '*') {
                            ans.add(x * y);
                        } else {
                            ans.add(x / y);
                        }
                    }
                }
            }
        }
        if(ans.size() == 0) ans.add(Integer.parseInt(expression));

        return ans;
    }
}






//       -------------Approach2-------------------------

// Using a mapDp to store List<Integer> .. wHENEVER WE GET THE SAME STRING WE JUST RETURN THE LIST rather to recurivly going deep

/*

Memoized Approach (with mapDp):
Time Complexity: O(n^3)
Space Complexity: O(n^3)

*/

  class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> mapDp = new HashMap<>();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftSubTree;
                List<Integer> rightSubTree;
                if(mapDp.containsKey(left))
                {
                    leftSubTree = mapDp.get(left);
                } else {
                    leftSubTree = diffWaysToCompute(left);
                }
                if(mapDp.containsKey(right))
                {
                    rightSubTree = mapDp.get(right);
                } else {
                    rightSubTree = diffWaysToCompute(right);
                }

                
                for (int x : leftSubTree) {
                    for (int y : rightSubTree) {
                        if (ch == '+') {
                            ans.add(x + y);
                        } else if (ch == '-') {
                            ans.add(x - y);
                        } else if (ch == '*') {
                            ans.add(x * y);
                        } else {
                            ans.add(x / y);
                        }
                    }
                }
            }
        }
        if(ans.size() == 0) ans.add(Integer.parseInt(expression));

        return ans;
    }
}
