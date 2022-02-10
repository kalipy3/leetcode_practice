/*
 * 剑指offer18.java
 * Copyright (C) 2022 2022-02-06 16:20 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
