// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
         rightView(root,result,0);
         return result;
    }
    public void rightView(TreeNode root,ArrayList<Integer> res,int level)
    {
        if(root == null) return ;
        if(res.size() == level) res.add(root.val);

        rightView(root.right,res,level+1);
        rightView(root.left,res,level+1);
    }
}
