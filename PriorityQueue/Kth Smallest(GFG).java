/*
https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

Examples :

Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output:  7
Explanation: 3rd smallest element in the given array is 7.
Input: arr[] = [7, 10, 4, 20, 15], k = 4 
Output:  15
Explanation: 4th smallest element in the given array is 15.

  */

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());   // Max Heap
        
        for(int i : arr)
        {
            pq.offer(i);
            
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
        
    }
}
