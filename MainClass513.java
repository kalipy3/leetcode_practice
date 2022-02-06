/*
 * MainClass513.java
 * Copyright (C) 2022 2022-01-27 11:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码 简单

//方法一 评论区
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);//先入队右！！
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }
}

//写法二 kalipy一次过
class Solution {
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }

                if (i == 0) {
                    ans = n.val;
                }
            }
        } 
        return ans;
    }
}

//方法二 kalipy一次过
class Solution {
    int ans = 0;
    int maxDept = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return ans;

        dfs(root, 0);

        return ans;
    }

    private void dfs(TreeNode root, int dept) {
        if (root == null) return;

        dept++;
        if (dept > maxDept && root.left == null && root.right == null) {
            ans = root.val;
            maxDept = dept;
        }
        dfs(root.left, dept);
        dfs(root.right, dept);
    }
}
