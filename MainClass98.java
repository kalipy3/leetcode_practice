class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}

作者：sweetiee
链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//kalipy一次过
class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;

        if(!dfs(root.left)) return false;


        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;


        return dfs(root.right);
    }
}

//kalipy一次过 推荐
class Solution {
    TreeNode pre = null;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);

        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (pre != null && root.val <= pre.val) {
            ans = false;
            return;
        }
        pre = root;

        dfs(root.right);
    }
}
