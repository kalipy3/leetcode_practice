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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

//方法二
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode arr[] = new ListNode[100];
        int i = 0;

        while (head != null) {
            arr[i++] = head;
            head = head.next;
        }

        return arr[i/2];
    }
}
