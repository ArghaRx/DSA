// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/


class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i - difference, 0) + 1);
            length = Math.max(length, map.get(i));
        }
        return length;
    }
}
