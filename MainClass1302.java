/*
 * MainClass1302.java
 * Copyright (C) 2022 2022-01-26 15:24 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    int ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
                levelSum += n.val;

            }
            ans = levelSum;
        }

        return ans;
    }
}

//kalipy一次过
class Solution {
    int ans = 0;
    int maxDept = 0;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);

        return ans;
    }

    private void dfs(TreeNode root, int dept) {
        if (root == null) return;
        dept++;

        if (root.left == null && root.right == null) {
            if (dept > maxDept) {
                maxDept = dept;
                ans = root.val;
            } 
            else if (dept == maxDept) {
                ans += root.val;
            }
        }

        dfs(root.left, dept);
        dfs(root.right, dept);
    }
}
