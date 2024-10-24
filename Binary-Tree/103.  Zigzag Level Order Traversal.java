// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // declare the direction
        boolean leftToRight = true;

        if(root == null) return ans;

        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);

                // now when add it to sub, check
                if(leftToRight) // true
                {
                    sub.add(queue.poll().val);
                }
                else // false, right to left (reverse)
                {
                    sub.add(0, queue.poll().val);
                }
            }
            // after one level complete, direction will be change
            leftToRight =! leftToRight;
            ans.add(sub);
        }

        return ans;
    }
}
