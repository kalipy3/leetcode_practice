/*
 * MainClass450.java
 * Copyright (C) 2022 2022-01-26 21:26 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/miao-dong-jiu-wan-shi-liao-by-terry2020-tc0o/
//根据二叉搜索树的性质
//
//    如果目标节点大于当前节点值，则去右子树中删除；
//    如果目标节点小于当前节点值，则去左子树中删除；
//    如果目标节点就是当前节点，分为以下三种情况：
//        其无左子：其右子顶替其位置，删除了该节点；
//        其无右子：其左子顶替其位置，删除了该节点；
//        其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key); // 去右子树删除

        else if(key < root.val)    
            root.left = deleteNode(root.left, key);  // 去左子树删除

        else  {  // 当前节点就是要删除的节点

            if (root.left == null)   return root.right;      // 情况1，欲删除节点无左子
            else if (root.right == null)  return root.left;  // 情况2，欲删除节点无右子
            else if (root.left!=null && root.right !=null){  // 情况3，欲删除节点左右子都有 
                TreeNode node = root.right;   
                while (node.left != null)      // 寻找欲删除节点右子树的最左节点
                    node = node.left;

                node.left = root.left;     // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                root = root.right;         // 欲删除节点的右子顶替其位置，节点被删除
            }
        }
        return root;    
    }
}
