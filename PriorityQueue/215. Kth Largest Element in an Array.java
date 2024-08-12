/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

*/

// prirityQueue jodi largest chai the minheap hba, minimum chaile maxheap hba
// ekn eta largest tai mminheap nie6i and size kre6i k, jkn e k er teke boro hoe jabe poll() hba
// tate alltime pq.peek() e kth largest e takbe, setai return hba

import java.util.PriorityQueue;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums)
        {
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}