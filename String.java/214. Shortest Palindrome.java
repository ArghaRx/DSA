// https://leetcode.com/problems/shortest-palindrome/


class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = s.length() - 1;

        // Find the largest palindromic prefix
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                String sub = s.substring(0, j + 1);
                if (isPalindrome(sub)) {
                    // Append the reversed non-palindromic suffix
                    sb.append(s.substring(j + 1)).reverse();
                    // Combine the reversed suffix and the original string
                    return sb.toString() + s;
                } else {
                    j--;
                }
            } else {
                j--; // Keep reducing j to find a palindromic prefix
            }
        }

        // If no palindromic prefix found, reverse the entire string and prepend it
        sb.append(new StringBuilder(s).reverse());
        return sb.toString() + s;
    }

    // Helper function to check if a string is a palindrome
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
