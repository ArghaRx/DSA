// https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String arr[] = str.split("\\.");
        String ans = "";
        // int ind = 0;
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            ans += "." + arr[i];
        }
        
        return ans.substring(1);
    }
}
