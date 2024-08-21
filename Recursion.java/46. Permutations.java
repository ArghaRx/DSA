/*
https://leetcode.com/problems/permutations/description/

All solution(Combination sum 1, 2 , permutation sum 1 2) - https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning

--------------------------------------------------------------------------------------------------------
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> sublist, int nums[])
    {
        // Base condition
        if(sublist.size() == nums.length)
        res.add(new ArrayList<>(sublist));

        for(int i = 0; i < nums.length ; i++)
        {
            if(sublist.contains(nums[i])) continue;
            sublist.add(nums[i]);
            backtracking(res, sublist, nums);
            sublist.remove(sublist.size() - 1);
        }
    }
}
