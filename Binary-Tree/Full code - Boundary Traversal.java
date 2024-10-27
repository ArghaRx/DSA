// https://ide.geeksforgeeks.org/online-java-compiler/b32075d2-bf46-4d43-815a-70fff7d91081

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        List<Integer> list = new ArrayList<>();
        boundaryTraversal(root, list);

        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void boundaryTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        
        if (!isLeaf(root)) {
            res.add(root.val);
        }

        addLeftBoundary(root, res);
        addLeavesBoundary(root, res);
        addRightBoundary(root, res);
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.left;
        
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.val);
            
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    public static void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
         
        while (cur != null) {
            if (!isLeaf(cur)) temp.add(cur.val);
             
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
         
        // Add right boundary in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    public static void addLeavesBoundary(TreeNode root, List<Integer> res) {
        if (root == null) return;

        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            addLeavesBoundary(root.left, res);
            addLeavesBoundary(root.right, res);
        }
    }
}
