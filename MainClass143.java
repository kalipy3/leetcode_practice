//1 -> 2 -> 3 -> 4 -> 5 -> 6
//第一步，将链表平均分成两半
//1 -> 2 -> 3
//4 -> 5 -> 6
//    
//第二步，将第二个链表逆序
//1 -> 2 -> 3
//6 -> 5 -> 4
//    
//第三步，依次连接两个链表
//1 -> 6 -> 2 -> 5 -> 3 -> 4

//官方题解
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}


//kalipy一次过
class Solution {
    public void reorderList(ListNode head) {

        ListNode l1 = head;
        ListNode mid = findMid(l1);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        merge(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode head = l1;

        while (l2 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
