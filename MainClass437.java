/*
 * MainClass437.java
 * Copyright (C) 2022 2022-01-26 12:19 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy两次过
class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        //dfs(root.left, targetSum);//极其易错点！！！！！！！！kalipy就是不长记性！！！！
        //dfs(root.right, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;

        targetSum -= root.val;
        if (targetSum == 0) {
            ans++;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}
