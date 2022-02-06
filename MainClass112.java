//评论区 推荐
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}


//kalipy自己的三种写法
class Solution {
    int sum = 0;
    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        dfs(root, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;

        sum += root.val;
        if (root.left==null && root.right==null && sum==targetSum) {
            ans = true;
            return;
        }

        dfs(root.left, targetSum);
        //sum -= root.val;
        dfs(root.right, targetSum);
        sum -= root.val;

    }
}

class Solution {
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        dfs(root, targetSum, 0);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) return;

        sum += root.val;
        if (root.left==null && root.right==null && sum==targetSum) {
            ans = true;
            return;
        }

        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);

    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) return false;

        sum += root.val;
        if (root.left==null && root.right==null && sum==targetSum) {
            return true;
        }

        boolean l = dfs(root.left, targetSum, sum);
        boolean r = dfs(root.right, targetSum, sum);

        return l || r;

    }
}

