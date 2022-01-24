//kalipy一遍过
class Solution {
    public int getDecimalValue(ListNode head) {
        int cur = 0;
        while (head != null) {
            cur = (cur << 1) + head.val;
            head = head.next;
        }
        return cur;

    }
}
