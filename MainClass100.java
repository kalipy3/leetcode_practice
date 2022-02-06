/*
 * MainClass100.java
 * Copyright (C) 2022 2022-01-26 11:53 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次过
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
