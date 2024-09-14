// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

class Solution {
    public int longestSubarray(int[] nums) {
        int maxiEl = 0;
        for(int i : nums)
        if(i > maxiEl) maxiEl = i;

        int cnt = 0;
        int consequtive = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == maxiEl) cnt++;
            else
            {
                consequtive = Math.max(cnt, consequtive);
                cnt = 0;
            }
        }
        consequtive = Math.max(cnt, consequtive);
        return consequtive;
        


    }
}