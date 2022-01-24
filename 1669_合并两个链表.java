//kalipy
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;

        ListNode p = list1;
        ListNode q = list1;
        ListNode k = list2;

        for (int i = 0; i < a-1; i++) {
            p = p.next;
        }

        for (int i = 0; i < b+1; i++) {
            q = q.next;
        }

        while (k != null && k.next != null) {
            k = k.next;
        }

        p.next = list2;
        k.next = q;
        return dummy.next;
    }
}
