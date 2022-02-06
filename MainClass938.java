/*
 * MainClass938.java
 * Copyright (C) 2022 2022-01-26 20:04 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次过
class Solution {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        dfs(root, low, high);

        return ans;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        dfs(root.left, low, high);

        if (root.val >= low && root.val <= high) {//这三句代码在前中后遍历顺序中都行
            ans += root.val;
        }

        dfs(root.right, low, high);
    }
}
