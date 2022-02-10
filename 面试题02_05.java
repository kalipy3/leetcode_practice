/*
 * 面试题02_05.java
 * Copyright (C) 2022 2022-02-06 18:06 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int a = p1 == null ? 0 : p1.val;
            int b = p2 == null ? 0 : p2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            k.next = new ListNode(sum);
            k = k.next;

            if (p1 != null)
            p1 = p1.next;
            if (p2 != null)
            p2 = p2.next;
        }

        if (carry == 1) {
            k.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
