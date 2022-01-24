//直接看代码
class Solution {
    // 用来返回的返回值
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curr) {
        // 遇到空节点，什么都不做，直接返回
        if (root == null) return;
        // 累加当前节点的值到当前路径和中
        curr = (curr << 1) + root.val;
        // 如果遇到叶子节点，就把路径和放到返回值中
        if (root.left == null && root.right == null) sum += curr;
        // 继续深度优先搜索左右子节点
        dfs(root.left, curr);
        dfs(root.right, curr);
    }
}


