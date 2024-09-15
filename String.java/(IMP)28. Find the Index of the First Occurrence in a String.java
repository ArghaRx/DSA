// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


class Solution {
    public int strStr(String haystack, String needle) {

        // If haystack is shorter than needle, no match is possible
        if (haystack.length() < needle.length()) return -1;

        // Traverse the haystack
        // haystack.length() - needle.length() --> This is because the loop klast will be iterate upto the length of needle...otota jeno last e takei,, tar age obdhi
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack from i to i+needle.length() matches needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the starting index of the match
            }
        }
        
        // If no match is found, return -1
        return -1;
    }
}
