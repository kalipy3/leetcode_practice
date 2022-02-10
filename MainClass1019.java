/*
 * MainClass1019.java
 * Copyright (C) 2022 2022-02-06 17:06 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy暴力破解
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        ListNode cur = head;
        for (ListNode i = cur; i != null; i = i.next) {
            k.next = new ListNode(0);
            k = k.next;
            for (ListNode j = i.next; j != null; j = j.next) {
                if (i.val < j.val) {
                    k.val = j.val;
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        cur = dummy.next;
        while (cur != null) {
            ans.add(cur.val);
            cur = cur.next;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
