/*
 * MainClass701.java
 * Copyright (C) 2022 2022-01-26 19:51 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//评论区 请直接看代码 可以看懂
/**
 * 递归版
 */
//kalipy解释 这种方法插入的地方一定是叶子节点(即不会拆散原先的结构)
public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root == null){
        return new TreeNode(val);
    }
    if(root.val < val){
        root.right = insertIntoBST(root.right,val);
    } else {
        root.left = insertIntoBST(root.left,val);
    }
    return root;
}

