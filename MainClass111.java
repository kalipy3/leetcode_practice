class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        return Math.min(l, r)+1;
    }
}
//其它写法
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/tu-jie-dfs-xie-liao-si-ban-bfs-xie-liao-yi-ban-by-/
