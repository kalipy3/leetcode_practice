/*
 * MainClass99.java
 * Copyright (C) 2022 2022-01-26 12:30 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//题目太简单了算不上hard。官方题解写的太啰嗦了。 根据题意分析只需要中序遍历找到，第一个升序顺序错乱最大值节点，和最后一个升序顺序错乱的最小值节点。然后交换两个节点val即可。
//https://leetcode-cn.com/problems/recover-binary-search-tree/solution/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/

class Solution {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
