/*
 * MainClass1367.java
 * Copyright (C) 2022 2022-01-27 12:18 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
