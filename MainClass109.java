/*
 * MainClass109.java
 * Copyright (C) 2022 2022-02-06 18:16 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请先看108题

//方法一
//只有我是先转换为数组，然后在构造树的吗
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        return create(list, 0, list.size() - 1);
    }

    private TreeNode create(List<Integer> list, int l, int r) {
        if (l > r) return null;

        int mid = (r + l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = create(list, l, mid - 1);
        root.right = create(list, mid + 1, r);

        return root;
    }
}

//方法二 官方题解
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

//方法三 官方题解
class Solution {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
