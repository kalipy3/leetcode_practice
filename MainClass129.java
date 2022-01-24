//官方题解 方法一
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

//写法一
class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        backtrack(root,0);
        return res;
    }
    public void backtrack(TreeNode root,int sum){
        if (root == null) return;
        sum = sum*10+root.val;
        if (root.left == null && root.right == null) res+=sum;
        backtrack(root.left,sum);
        backtrack(root.right,sum);
    }
}

//写法三 kalipy 回溯
class Solution {
    int ans = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) ans += sum;

        dfs(root.left);
        //sum = (sum - root.val) / 10;
        dfs(root.right);
        sum = (sum - root.val) / 10;
    }
}
