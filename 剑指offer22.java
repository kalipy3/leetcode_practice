
//先看下思路，然后后直接看代码
//kalipy
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);//不可少，请用[1,2] 2用例测试就知道了,要不就用写法二
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

//官方题解 写法二
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
