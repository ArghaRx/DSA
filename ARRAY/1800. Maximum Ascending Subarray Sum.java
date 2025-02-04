https://leetcode.com/problems/maximum-ascending-subarray-sum/description/


class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], maxsum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i - 1])
            {
                sum += nums[i];
            }
            else
            {
                maxsum = Math.max(maxsum, sum);
                sum = nums[i];
            }
        }
        return maxsum = Math.max(maxsum, sum);
    }
}

