// https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/



class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        sb.append(s.charAt(0));
        char cur = s.charAt(0);

        for(int i = 1; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(cur == ch) 
            {
                cnt++;
            }
            else
            {
                cur = ch;
                cnt = 1;
            }
            if(cnt < 3)
            {
                sb.append(ch);
            }
        }


        return sb.toString();
    }
}
