class Pair {
    Node node;
    int line;
    
    Pair(Node node, int line)
    {
        this.node = node;
        this.line = line;
    }
}


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
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
            /*
            only change:- jodi map e take tao map e dukbe ar na takleo dukbe
            then sese sei last update tai pore takbe mane leaf node gulo jeta hba bottom view
            */


            if (!map.containsKey(line) || map.containsKey(line)) {
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
