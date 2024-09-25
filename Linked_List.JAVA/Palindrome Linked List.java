/// https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1


class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
 Node temp = head;
        
        // List to store the values of the nodes
        List<Integer> list = new ArrayList<>();
        
        // Traverse the linked list and store its elements in the list
        while(temp != null)
        {
            list.add(temp.data);
            temp = temp.next;  // Corrected to move 'temp' to the next node
        }
        
        // Two-pointer technique to check if the list is a palindrome
        int i = 0;
        int j = list.size() - 1;
        
        while(i <= j)
        {
            if(!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }
        return true;
        
    }
}
