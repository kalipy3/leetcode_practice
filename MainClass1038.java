/*
 * MainClass1038.java
 * Copyright (C) 2022 2022-01-26 20:47 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//如果看不懂题目意思，直接看这个解题思路，即可明白题目意思，且能够做错来!
//解题思路
//计算所有的大于等于当前结点val的所有结点val之和并替换，体现在BST中就是：该结点val+右子树val之和——>该结点val
//
//    那么要计算右子树，且是一个累计的过程，所以我们可以从最右下开始
//    一个合理的计算顺序：右->根->左
//    发现这不就是中序然后将左右换个顺序么？

//kalipy一次过
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;

        dfs(root);

        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);

        sum += root.val;
        root.val = sum;

        dfs(root.left);
    }
}
