https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/tu-jie-shan-chu-lian-biao-zhong-de-jie-dian-python/

public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}


