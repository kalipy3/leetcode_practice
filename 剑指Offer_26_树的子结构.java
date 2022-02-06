/*
 * 剑指Offer_26_树的子结构.java
 * Copyright (C) 2022 2022-01-26 20:39 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
/*
//评论区 请直接看代码
var isSubStructure = function (A, B) {
    // 主函数用来确定根起点
    // 需要特判：
    // A === null，这说明 **从某一支出发到达叶子节点 ** 都无法找到一个节点与 B 的根相同，自然就不存在子结构
    // B === null，题目约定空树不是任意一个树的子结构
    if (A === null || B === null) return false
    // 先从根节点开始，最特殊的情况，A与B 完全相同，那么通过短路运算，后续的 isSubStructure 便不会再递归执行
    // 若一开始的 isSame 为 false ，说明以当前根为起点的A并无与B相同的子结构
    // 需要递归，将根起点设为 A.left
    return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
};

var isSame = function (A, B) {
    // 副函数用来确定结构是否相同
    if (B === null) {
        // 如果 B 树的所有点都被遍历完了（指的是到达B叶子下方），说明 A 中存在该子结构（或只是其中一枝）
        return true
    }
    if (A === null) {
        // 如果 B 树还有节点没被遍历而A已经遍历完了（指的是到达A叶子下方），说明 A 中不存在该子结构
        return false
    }
    // 如果当前俩节点对应值相同，那么递归确定子节点是否相同（再次使用了短路运算符）
    return A.val === B.val && isSame(A.left, B.left) && isSame(A.right, B.right)
}
*/

//评论区 请直接看代码
public boolean isSubStructure(TreeNode A, TreeNode B) {
    if(A == null || B == null) return false;
    return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
}
public boolean dfs(TreeNode A, TreeNode B){
    if(B == null) return true;
    if(A == null) return false;
    return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
}
