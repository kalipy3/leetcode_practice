/*
 * MainClass117.java
 * Copyright (C) 2022 2022-01-26 16:08 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//这题让求的就是让把二叉树中每行都串联起来
//链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/
//方法一 请直接看代码，可以看懂
public Node connect(Node root) {
    if (root == null)
        return root;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        //每一层的数量
        int levelCount = queue.size();
        //前一个节点
        Node pre = null;
        for (int i = 0; i < levelCount; i++) {
            //出队
            Node node = queue.poll();
            //如果pre为空就表示node节点是这一行的第一个，
            //没有前一个节点指向他，否则就让前一个节点指向他
            if (pre != null) {
                pre.next = node;
            }
            //然后再让当前节点成为前一个节点
            pre = node;
            //左右子节点如果不为空就入队
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
    return root;
}

//方法二 推荐
public Node connect(Node root) {
    if (root == null)
        return root;
    //cur我们可以把它看做是每一层的链表
    Node cur = root;
    while (cur != null) {
        //遍历当前层的时候，为了方便操作在下一
        //层前面添加一个哑结点（注意这里是访问
        //当前层的节点，然后把下一层的节点串起来）
        Node dummy = new Node(0);
        //pre表示访下一层节点的前一个节点
        Node pre = dummy;
        //然后开始遍历当前层的链表
        while (cur != null) {
            if (cur.left != null) {
                //如果当前节点的左子节点不为空，就让pre节点
                //的next指向他，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;
            }
            //同理参照左子树
            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            //继续访问这一行的下一个节点
            cur = cur.next;
        }
        //把下一层串联成一个链表之后，让他赋值给cur，
        //后续继续循环，直到cur为空为止
        cur = dummy.next;
    }
    return root;
}

