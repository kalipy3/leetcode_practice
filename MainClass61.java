//kalipy一次过
//说是循环旋转，但其实本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        //计算链表长度
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        k = k % n;
        if (k == 0) return head;

        //找倒数第k个节点的前一个节点
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //拼接
        ListNode t = slow.next;
        slow.next = null;
        fast.next = head;

        return t;
    }
}


//先看官方题解的思路
//kalipy
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        cur.next = head;

        ListNode pre = null;
        cur = head;
        for (int i = 0; i < n - k % n; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;

        return cur;
    }
}
