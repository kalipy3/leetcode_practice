//官方题解 送分题
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

//看完这题，请去看82题，请对比下二者的区别



//方法二 kalipy一次过
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;
        while (cur != null) {
            if (cur != null && cur.next != null && cur.val == cur.next.val) {
                ListNode t = cur;
                while (t != null && t.next != null && t.val == t.next.val) {
                    t = t.next;
                }
                cur.next = t.next;
                cur = t;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
