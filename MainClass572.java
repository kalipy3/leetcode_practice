//kalipy正解
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;//不能少
        if (subRoot == null) return true;//不能少
        //return dfs(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);//错误写法
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);//正确写法
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;

        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
}



//:Author: kalipy
//:Email: 3069087972@qq.com 
//:Date: 2022年 01月 25日 星期二 22:29:18 CST 
//官方题解
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}

