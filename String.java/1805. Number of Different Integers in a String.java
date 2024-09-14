
// https://leetcode.com/problems/number-of-different-integers-in-a-string/description/

import java.math.BigInteger;
import java.util.*;
class Solution {
    public int numDifferentIntegers(String word) {
        int n = word.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            
            if (Character.isDigit(word.charAt(i))) {
                int ind = i;
                while (ind < n && Character.isDigit(word.charAt(ind))) {
                    ind++;
                }
                
                // Use BigInteger for large numbers and remove leading zeros by converting to String
                String numStr = new BigInteger(word.substring(i, ind)).toString();
                set.add(numStr);
                i = ind - 1;
            }
        }
        return set.size();
    }
}