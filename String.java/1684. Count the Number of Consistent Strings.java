// https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
import java.util.*;
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : allowed.toCharArray())
        map.put(c, map.getOrDefault(c, 0) + 1);

        int cnt = 0;
        for(String str : words)
        {
            boolean flag = true;
            for(char c : str.toCharArray())
            {
                if(!map.containsKey(c)) 
                {
                    flag = false;
                    break;
                }
            }
            if(flag == true) cnt++;
        }
        return cnt;
    }
}