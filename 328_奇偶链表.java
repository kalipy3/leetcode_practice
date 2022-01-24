//kalipy
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode p = head;//奇链表
        ListNode q_head = head.next;//偶链表头指针
        ListNode q = head.next;//偶链表

        while (p != null && q != null && p.next != null && q.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }

        p.next = q_head;
        // q.next = null;

        return head;
    }
}
