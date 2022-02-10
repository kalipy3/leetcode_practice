//方法一 kalipy一次过
class Solution {
    public boolean isPalindrome(ListNode head) {
        int arr[] = new int[100000];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }

        int l = 0;
        int r = i-1;
        while (l < r) {
            if (arr[l] != arr[r]) return false;
            l++;
            r--;
        }

        return true;
    }
}


//方法二
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }        

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //while (fast != null && fast.next != null) {//error 因为有1,2这种两个节点的用例
        while (fast.next != null && fast.next.next != null) {//ok
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
