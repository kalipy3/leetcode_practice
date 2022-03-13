//请直接看代码
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;//error 注意：不是这样pA = pA == null ? pB : pA.next;在这里死了无数次，非常难以避免的粗心
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

