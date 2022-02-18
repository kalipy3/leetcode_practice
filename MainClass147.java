/*
 * MainClass147.java
 * Copyright (C) 2022 2022-02-16 10:41 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区
//想要排序块，就要尽可能少的做比较
//需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
//需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
//每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
//如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while(head != null && head.next != null) {
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
