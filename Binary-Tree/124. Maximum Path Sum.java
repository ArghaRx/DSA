/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/


Time Complexity: O(N).

Reason: We are doing a tree traversal.

Space Complexity: O(N)

Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).


*/



class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDownValue(root);
        return maxValue;
    }

    // height eri formula just 1 er jaiga gulo root.val kre6i,
    //karon ultimately otai chai
    public int maxDownValue(TreeNode root)
    {
        if(root == null) return 0;

        // for any root, left or right --> comes -ve value,that can never be my highest value
        // so 0 return tai, max(0,...) kore6i
        int lh = Math.max(0,maxDownValue(root.left));
        int rh = Math.max(0,maxDownValue(root.right));

        // update maxvalue for each node
        maxValue = Math.max(maxValue, rh + lh + root.val);

        // traverse e sei path tai nbo jeta maximum, tai backtarcking r jnno ota,
        // val + max(lh, rh)
        return (root.val + Math.max(lh,rh));


    }
}

