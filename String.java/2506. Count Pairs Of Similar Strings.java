// https://leetcode.com/problems/count-pairs-of-similar-strings/description/

class Solution {
    public int similarPairs(String[] words) {
        int n = words.length;
        int cnt = 0;
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(isEqualPair(words[i], words[j]))
                cnt++;
            }
        }
        return cnt;
    }
    public boolean isEqualPair(String a, String b)
    {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char c : a.toCharArray())
        set1.add(c);
        for(char ch : b.toCharArray())
       set2.add(ch);

        return set1.equals(set2);
    }
}