//kalipy 一次过 推荐 可以避坑！！！
class Solution {
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, dept);
        return ans;
    }

    public void dfs(TreeNode root,int dept) {
        if (root == null) return;

        dept++;
        dfs(root.left, dept);
        if (root.left == null && root.right == null) {//if中的三句的位置可以随便是前中后遍历，都行
            ans = Math.min(ans, dept);
        }
        dfs(root.right, dept);
    }
}

//kalipy一次过 写法二
class Solution {
    int ans = Integer.MAX_VALUE;
    int dept = 0;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dept++;
        dfs(root.left);
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, dept);
        }
        dfs(root.right);
        dept--;
    }
}


//评论区
//和求最大深度相反
//
//public int maxDepth(TreeNode root) {
//    if (root == null) {
//        return 0;
//    }
//    return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
//}
//
//求最小深度时将Math.max换成Math.min即可，但要注意如果根节点的左或右子树为空的话是构不成子树的。而最小深度是要求从根节点到子树的。当左或右子树为空时，不符合要求。

public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    // null节点不参与比较
    if (root.left == null && root.right != null) {
        return 1 + minDepth(root.right);
    }
    // null节点不参与比较
    if (root.right == null && root.left != null) {
        return 1 + minDepth(root.left);
    }

    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}

