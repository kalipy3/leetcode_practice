/*
 * MainClass589.java
 * Copyright (C) 2022 2022-02-17 19:13 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次过 送分题
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {


        if (root == null) return ans;
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root == null) return;

        ans.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }
}
