//官方题解 推荐递归的写法二
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}

//递归写法二
//var swapPairs = function (head) {
//    if (!head || !head.next) return head
//    var one = head
//    var two = one.next
//    var three = two.next
//
//    two.next = one
//    one.next = swapPairs(three)
//
//    return two
//};

//官方题解
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}

//kalipy一次过 推荐
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = cur;
            pre.next = next;

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
