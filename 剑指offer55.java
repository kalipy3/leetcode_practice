//kalipy差点一次过 因为少了&& isBalanced(root.left) && isBalanced(root.right)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int l = dfs(root.left);
        int r = dfs(root.right);

        return Math.abs(l-r) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right))+1;
    }
}
