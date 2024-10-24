/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxDownValue(root,maxValue);
        return maxValue[0];
    }

    public int maxDownValue(TreeNode root,int maxValue[] )
    {
        if(root == null) return 0;
        int lh = Math.max(0,maxDownValue(root.left , maxValue));
        int rh = Math.max(0,maxDownValue(root.right , maxValue));
        maxValue[0] = Math.max(maxValue[0], rh + lh + root.val);

        return (root.val + Math.max(lh,rh));


    }
}

Time Complexity: O(N).

Reason: We are doing a tree traversal.

Space Complexity: O(N)

Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).
