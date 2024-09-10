// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp.next != null)
        {
            // if(temp.next == null) break;
            ListNode next = temp.next;
            int gcd = findGCD(temp.val, next.val);
            ListNode newNode = new ListNode(gcd);
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }
        return head;
    }
    public int findGCD(int n1, int n2)
    {
        int gcd = 1;
        for(int i = 1; i <= n1 && i <= n2; i++)
        {
            if(n1 % i == 0 && n2 % i == 0)
            gcd = i;
        }
        return gcd;
    }
}
