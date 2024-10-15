//  https://leetcode.com/problems/separate-black-and-white-balls/description/

class Solution {
    public long minimumSteps(String s) {
        long swap = 0;
        long black = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') swap += black;
            else black++;
        }
        return swap;
    }
}
