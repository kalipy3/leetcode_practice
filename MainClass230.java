//kalipy一次过
class Solution {
    int k = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);

        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        };
        dfs(root.right);


    }
}

