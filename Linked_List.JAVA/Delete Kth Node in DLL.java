gfg -- https://ide.geeksforgeeks.org/online-java-compiler/995a6ea1-9c11-4bdd-9007-3e153f275964


/*
    Delete Kth node of Doubly Linked List
 ---- Run a loop and reach the kth position
    -- if kth is first the DeleteHead() call
    -- if kth is last then DeleteTail() call
    -- otherwise delete middle node
*/

import java.util.*;

class Node{
    public int data;
    public Node next;
    public Node prev;
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
        
        int kth = sc.nextInt();
        
        Node head = convertArraytoDLL(arr, n);
        head = kthNodeDelete(head, kth);
        printDLL(head);
    }
    
    public static Node convertArraytoDLL(int arr[], int n)
    {
        Node head = new Node(arr[0]);
        Node temp = head;
        
        for(int i = 1; i < n; i++)
        {
            Node curr = new Node(arr[i], null, temp);
            temp.next = curr;
            temp = temp.next;
        }
        return head;
    }
    
    public static Node kthNodeDelete(Node head, int k){
        if(head == null || head.next == null) return null;
        
        Node temp = head;
        while(temp != null)
        {
            k--;
            if(k == 0) break;
            
            temp = temp.next;
        }
       
        if(temp.prev == null) // if the delete node is Head
        {
           return deleteHeadofDLL(temp);
            
        }
        
        else if(temp.next == null) //if the delete node is Tail
        {
            return deleteTail(head);
            
        }
        else{
            //otherwise
            Node previous = temp.prev;
            Node front = temp.next;
            previous.next = front;
            front.prev = previous;
            temp.next = null;
            temp.prev = null;
        }
        return head;
    }
    
    // deleteHeadofDLL Function
    public static Node deleteHeadofDLL(Node head)
    {
        if(head == null || head.next == null) return null;
        
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        
        return head;
    }
    
    // deleteTail Function
    public static Node deleteTail(Node head)
    {
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        
        temp.prev.next = null;
        temp.prev = null;
        
        return head;
    }
    
    
    public static void printDLL(Node head)
    {
        Node cur = head;
        while(cur != null)
        {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}
