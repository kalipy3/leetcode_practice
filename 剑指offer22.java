//先看下思路，然后后直接看代码
//kalipy
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        dummy.next = slow;
        return dummy.next;

    }
}
