//官方题解
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}

//kalipy一次过 送分题
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return ans;

        dfs(root);

        return ans - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;


        int l = dfs(root.left);
        int r = dfs(root.right);

        ans = Math.max(ans, l + r + 1);

        return Math.max(l, r) + 1;
    }
}
