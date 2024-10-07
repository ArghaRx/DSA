// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/



class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            // Check if the stack is not empty before peeking
            if(!st.isEmpty() && ch == 'B' && st.peek() == 'A') st.pop();
            else if(!st.isEmpty() && ch == 'D' && st.peek() == 'C') st.pop();
            else st.push(ch);
        }
        return st.size();
    }
}

