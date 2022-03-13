/*
 * MainClass559.java
 * Copyright (C) 2022 2022-01-26 15:06 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    int ans = Integer.MIN_VALUE;
    int dept = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;

        dfs(root);

        return ans;
    }

    private void dfs(Node root) {
        if (root == null) return;

        dept++;

        if (root.children.size() == 0) {
            ans = Math.max(dept, ans);
        }

        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i));
        }

        dept--;
    }
}

//kalipy一次过

class Solution {
    int ans = 0;

    public int maxDepth(Node root) {
        if (root == null) return 0;

        dfs(root, 0);

        return ans;    
    }

    private void dfs(Node root, int dept) {
        if (root == null) return;
        dept++;
        if (root.children.size() == 0) {
            ans = Math.max(ans, dept);
        }

        for (Node n: root.children) {
            dfs(n, dept);
        }
    }
}
