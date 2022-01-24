//官方题解 //写法一
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

//写法二
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head, index2 = head;
        for(int i = 0; i < n; i++)  index2 = index2.next; //使得index1与index2之间间隔n-1个节点       
        if(index2 == null) return head.next;   //说明删除的是头节点
        while(index2.next != null){      //将index2移至最后一个节点
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return head;
    }
}

//写法三
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode index1 = dummy;
        ListNode index2 = dummy;
        for(int i = 0; i < n; i++)  index2 = index2.next;        
        
        while(index2.next != null){      
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return dummy.next;
    }
}
