// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/


class Solution {
    public char kthCharacter(int k) {
        String str = "a";
       
        while(str.length() <= k)
        {
            String s2 = "";
            int ind = 0;
            while(ind < str.length())
            {
                s2 += (char)(str.charAt(ind) + 1);
                ind++;
            }
            str += s2;
        }

        return str.charAt(k - 1);
    }
}
