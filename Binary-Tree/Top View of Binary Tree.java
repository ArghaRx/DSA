// gfg link --> https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

// Need Pair Class
class Pair {
    Node node;
    int line;
    
    Pair(Node node, int line)
    {
        this.node = node;
        this.line = line;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        
        // queue r mdde Pair hisebe dukbe Node, Integer
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(root, 0));

        // TreeMap to keep entries sorted by line (horizontal distance)
        // map e 2 toi int , int store krte hba, noito .getValue() kora jaba na...Node can't convert to int
        
        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            
            Pair pair = queue.poll(); // first pop one pair from queue
            
            /*
 jodi pair.getnode() or pair.getline() esb use kori then amke alade kore 
        getNode, getline esb declare krte hba

       // Getter for node
    public Node getnode() {
        return node;
    }

    // Getter for line
    public int getline() {
        return line;
    }

            */
            
            Node node = pair.node;
            int line = pair.line;

            // If the line is not already in the map, add the node's data
            if (!map.containsKey(line)) {
                map.put(line, node.data);
            }

            // Process left and right children
            // jodi lefte jai then decrese hba line
            // right e gala increase hba line tai line -1 or line  + 1
            if (node.left != null) queue.offer(new Pair(node.left, line - 1));
            if (node.right != null) queue.offer(new Pair(node.right, line + 1));
        }

        // Transfer values from the map to the result list
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }

}



Time Complexity: O(N)

Space Complexity: O(N)
