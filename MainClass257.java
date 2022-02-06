/*
 * MainClass257.java
 * Copyright (C) 2022 2022-01-26 14:40 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;

        dfs(root, "");

        return ans;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) return;

        path += root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
        }

        dfs(root.left, path + "->");
        dfs(root.right, path + "->");
    }
}

//评论区 推荐
class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;

        dfs(root, new StringBuilder(""));

        return ans;
    }

    private void dfs(TreeNode root, StringBuilder cur) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(cur.toString() + root.val);
            return;
        }
        int sz = cur.length();
        cur.append(root.val).append("->");
        dfs(root.left, cur);
        dfs(root.right, cur);
        cur.delete(sz, cur.length());
    }
}
