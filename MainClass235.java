/*
 * MainClass235.java
 * Copyright (C) 2022 2022-01-27 13:31 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//评论区 请直接看代码 请先看236题
//直接用236的代码也ok
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val==root.val){
        return root;
    } 
    if (q.val==root.val){
        return root;
    }
    if (p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right,p,q);
    }else if (p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left,p,q);
    }else{
        return root;
    }
}
