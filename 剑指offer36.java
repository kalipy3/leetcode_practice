//作者：logilong
//链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/offer36er-cha-sou-suo-shu-yu-shuang-xian-1ant/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    private Node head; // 记录双向链表的头节点
    private Node pre; // 记录每个链表节点的前一个节点
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        // 当中序遍历完成后，pre 指向最后一个节点，即双向链表的尾部，此时便可将头尾连接
        head.left = pre;
        pre.right = head;
        return head;// 返回双向链表的头节点
    }
    private void dfs(Node cur){
        if(cur == null) return;// 当前节点为空，则直接返回。

        // 中序遍历：左 -> 中 -> 右
        dfs(cur.left);
        // 当 pre == null 即双向链表的前一个节点为空，则设置当前节点为头节点
        // 如果 pre != null , 则设置前一个节点的 right 为 当前节点
        if(pre != null) pre.right = cur;
        else head = cur;
        // 设置当前节点的 left 指向前一个节点
        cur.left = pre;
        // 更新pre
        pre = cur;
        dfs(cur.right);
    }
}

