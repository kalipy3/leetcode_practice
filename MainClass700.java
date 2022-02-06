/*
 * MainClass700.java
 * Copyright (C) 2022 2022-01-26 20:59 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
//方法一
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val == val) {
            return root;
        }

        return root;
    }
}

//kalipy一次过
//方法二
class Solution {
    TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        dfs(root, val);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        dfs(root.left, val);

        if (root.val == val) {
            ans = root;
            return;
        }

        dfs(root.right, val);
    }
}
