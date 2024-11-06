// https://leetcode.com/problems/find-if-array-can-be-sorted/description/


class Solution {
    public boolean canSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] <= nums[j + 1])
                    continue;
                else {
                    if (countOne(nums[j]) == countOne(nums[j + 1]))
                    {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int countOne(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n % 2 != 0)
                cnt++;

            n /= 2;
        }
        return cnt;
    }
}
