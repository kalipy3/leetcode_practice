//直接看代码
//第一个res++后面不能return，因为后面可能还会产生答案，比如后面还剩两个节点一个-1一个1，走完就又可以等于sum。 
class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return ans;

        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;

        sum -= root.val;
        if (sum == 0) {
            ans++;
            //return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        sum += root.val;
    }
}
