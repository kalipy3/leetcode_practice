/*
 * MainClass617.java
 * Copyright (C) 2022 2022-01-26 17:56 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy经评论区稍微提醒(主要是if判断缺了，导致没过)
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        //root1.val = root1.val + root2.val;//也ok
        TreeNode l = mergeTrees(root1.left, root2.left);
        TreeNode r = mergeTrees(root1.right, root2.right);

        root1.val = root1.val + root2.val;//这句话位置在前 后序遍历都行 因为方正最后都会回到root节点
        root1.left = l;
        root1.right = r;

        return root1;
    }
}
//kalipy经评论区稍微提醒(主要是if判断缺了，导致没过)
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        
        TreeNode l = mergeTrees(root1.left, root2.left);
        TreeNode r = mergeTrees(root1.right, root2.right);

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = l;
        root.right = r;

        return root;
    }
}


//评论区 请直接看代码 可以看懂
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    /**
     * 不修改原二叉树的解法 2
     * 复用 t1，t2 不重叠处的节点，既题目所说“不为 NULL 的节点将直接作为新二叉树的节点”
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        TreeNode root = new TreeNode(t1.val + t2.val);
        // 再递归合并左右子树
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
