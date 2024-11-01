_____CODE NINJA____



/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {
     public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();

        if (isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }


	
    static boolean isLeaf(TreeNode node){
    return (node.left == null && node.right == null);
    }

	
     static void addLeftBoundary(TreeNode root, ArrayList <Integer> res)
    {
        TreeNode cur = root.left;
        while (cur != null)
        {
	   // all left boundaries node come excluding leave
            if(isLeaf(cur) == false)
            res.add(cur.data);
		
	   // left boundary traversal tai aga left e jaba
            if(cur.left != null)
            cur = cur.left; // (see)
            else
            cur = cur.right; //(see)
        }
    }


	
     static void addRightBoundary(TreeNode root,ArrayList <Integer> res)
    {
        TreeNode cur = root.right;  // (see)

         ArrayList<Integer> temp = new ArrayList<>(); // for reverse order enter in ans list
        while(cur != null)
        {
            if(isLeaf(cur) == false) temp.add(cur.data);  // (see)
            
            if(cur.right != null) 
              cur= cur.right;  // (see)
            else
            cur = cur.left;   // (see)
        }

	// reverse order so last to first loop cholbe 
        for(int i = temp.size() - 1 ; i>=0 ; i--)
        {
            res.add(temp.get(i));
        }
            
    }

	
   static void addLeaves(TreeNode root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return; // return must after take one leaf
        }
        if (root.left != null) addLeaves(root.left, res);   // (see)// (see)
        if (root.right != null) addLeaves(root.right, res);  // (see)// (see)
    }

}









__________________________<< GfG >>________________________________________________________



class Solution
{
    boolean isLeaf(Node node)
    {
        return node.left == null && node.right == null;
    }

	// GIVEN FUNCTION______

	ArrayList<Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    // If the tree is empty, return the empty list
	    if (node == null) return ans;
	    
	    // The root is not added if it is a leaf node
	    if (!isLeaf(node))
	        ans.add(node.data);
	    
	    // Traverse the left boundary
	    traverseLeftBoundary(node, ans);
	    
	    // Traverse leaf nodes
	    traverseBoundary(node, ans);
	    
	    // Traverse the right boundary
	    traverseRightBoundary(node, ans);
	    
	    return ans;
	}
	
	void traverseLeftBoundary(Node node, ArrayList<Integer> res)
	{
	    Node cur = node.left;
	    while(cur != null)
	    {
	        if(isLeaf(cur) == false) res.add(cur.data);
	        if(cur.left != null) cur = cur.left;
	        else cur = cur.right;
	    }
	}
	
	void traverseRightBoundary(Node node, ArrayList<Integer> res)
	{
	    Node cur = node.right;
	    ArrayList<Integer> temp = new ArrayList<>();
	    
	    while(cur != null)
	    {
	        if(isLeaf(cur) == false) temp.add(cur.data);
	        if(cur.right != null) cur = cur.right;
	        else cur = cur.left;
	    }
	    
	    for(int i = temp.size() - 1; i >= 0; i--)
	    {
	        res.add(temp.get(i));
	    }
	}
	
	void traverseBoundary(Node node, ArrayList<Integer> res)
	{
	    
	        
	    if(isLeaf(node)) 
	    {
	        res.add(node.data);
	        return;
	    }
	    
	    
	    if(node.left != null) traverseBoundary(node.left, res);
	    if(node.right != null) traverseBoundary(node.right, res);
	}
}




