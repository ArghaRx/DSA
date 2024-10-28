// https://leetcode.com/problems/longest-square-streak-in-an-array/description/

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = -1;
        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && map.containsKey(sqrt)) {
                map.put(num, map.get(sqrt) + 1);
                maxi = Math.max(maxi, map.get(num));
            } else {
                map.put(num, 1);
            }
        }
        return maxi;
    }
}
