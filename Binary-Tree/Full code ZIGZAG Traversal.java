// https://ide.geeksforgeeks.org/online-java-compiler/a8998272-64f5-40e5-b8d4-590f770fb058



import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {};
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class A{
    public static void main (String[] args) {
        Scanner sc =  new Scanner(System.in);
         int rootVal = sc.nextInt();
         TreeNode root = new TreeNode(rootVal);
         int val1 = sc.nextInt();
         int val2 = sc.nextInt();
         int val3 = sc.nextInt();
         int val4 = sc.nextInt();
         int val5 = sc.nextInt();
         int val6 = sc.nextInt();
         root.left = new TreeNode(val1);
         root.right = new TreeNode(val2);
         root.left.left = new TreeNode(val3);
         root.left.right = new TreeNode(val4);
         root.right.left = new TreeNode(val5);
         root.right.right = new TreeNode(val6);
         
         List<List<Integer>> ans = new ArrayList<>();
         zigzagTraversal(root, ans);
         
          // Print result
          for (List<Integer> level : ans) {
            System.out.println(level);
         }
    }
    
    public static List<List<Integer>> zigzagTraversal(TreeNode root, List<List<Integer>> ans)
    {
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
         boolean leftToRight = true; // we have to initialise out of loop ******
        
        while(!queue.isEmpty())
        {
            List<Integer> sub = new ArrayList<>();
            int levelSize = queue.size();
            
            for(int i = 0; i < levelSize; i++)
            {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                
                if(leftToRight) sub.add(queue.poll().val);
                else sub.add(0, queue.poll().val);
            }
            
            // Toggle the direction for the next level
            leftToRight = !leftToRight;
            ans.add(sub);
        }
        
        return ans;
    }
}
