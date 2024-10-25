class Solution {
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        height(root);
        return maxi;
        
    }
    public int height(TreeNode root)
    {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        
        maxi = Math.max(maxi, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
