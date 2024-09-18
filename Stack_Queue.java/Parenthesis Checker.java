// https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1

import java.util.*;

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        for(char c : x.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[')
            {
                st.push(c);
            }
            
            else
            {
                // closing bracket found , so check if st.top() and 
                //       current chaa are different then return false
                if(st.isEmpty()) return false;
                
                char top = st.pop();
                
                if((c == ')' && top != '(') || (c == '}' && top != '{') 
                    || (c == ']' && top != '[')) return false;
            }
        }
        return st.isEmpty();
    }
}
