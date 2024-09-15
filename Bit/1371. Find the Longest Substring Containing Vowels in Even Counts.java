//  https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/



/* ********************************************************************************

APPROACH 1  
Approach-1 (Using map to store states)
T.C : O(n)
S.C : O(1)

***********************************************************************/ 

/*

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int findTheLongestSubstring(String s) {

        /// Initialize an array to track the count of each vowel
        int vowel[] = new int[5];  // {a,e,i,o,u} - count store

        /// Initial state where all vowels have even counts
        String str = "00000";

        Map<String, Integer> map = new HashMap<>();
        map.put(str, -1);

        int maxCount = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++)
        {
            ///  Update count for the vowel encountered
            if(s.charAt(i) == 'a') vowel[0] = (vowel[0] + 1) % 2;
            else if(s.charAt(i) == 'e') vowel[1] = (vowel[1] + 1) % 2;
            else if(s.charAt(i) == 'i') vowel[2] = (vowel[2] + 1) % 2;
            else if(s.charAt(i) == 'o') vowel[3] = (vowel[3] + 1) % 2;
            else if(s.charAt(i) == 'u') vowel[4] = (vowel[4] + 1) % 2;

            /// Create a string representing the current parity state of vowels
            String currentStr = "";
            for(int j = 0; j < 5; j++)
            {
                currentStr += vowel[j];
            }
            
            ///If this string is seen previous
            if(map.containsKey(currentStr))
            maxCount = Math.max(maxCount, i - map.get(currentStr));

            ///otherwise put it
            else
            map.put(currentStr, i);

        }
        return maxCount;
    }
}




*/


/* ********************************************************************************

APPROACH 2  
Approach-1 (Using map to store states)
T.C : O(n)
S.C : O(1)

Juat slidely changed. Xor opertor used here. Initially it was 0. when 1 element comes 0 ^ 1 = 0. and again when it again come so 1 ^ 1 = 0.
By this if even no of elemnt comes it automatically become zero
***********************************************************************/ 

// here a = 0, can be 000...0. string assume {u,o,i,e,a} . Initially 00000.
// when a comes we just left shift 1 by 0 means 1 time so string = 00001;
//when e comes we just left shift 1 by 1 means 2 times so string = 00010;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {

       
       int a = 0; // it can be any nos of 0 --> 0000...0

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, -1);

        int maxCount = 0;

         for (int i = 0; i < s.length(); i++) {
            int val = 0;
            if (s.charAt(i) == 'a')      val = (1 << 0);
            else if (s.charAt(i) == 'e') val = (1 << 1);
            else if (s.charAt(i) == 'i') val = (1 << 2);
            else if (s.charAt(i) == 'o') val = (1 << 3);
            else if (s.charAt(i) == 'u') val = (1 << 4);

            a ^= val;
                     
            //If this string is seen previous
            if(map.containsKey(a))
            maxCount = Math.max(maxCount, i - map.get(a));

            //otherwise put it
            else
            map.put(a, i);

        }
        return maxCount;
    }
}