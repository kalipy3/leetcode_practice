//官方题解 送分题
class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
            //注意这里不能return;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        //targetSum += root.val; 注意:这里不需要回溯，因为是函数局部变量，函数退出自动回溯
        path.pollLast();
    }
}


//kalipy一次过 送分题 写法二
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;

        dfs(root, targetSum, new LinkedList<>());

        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;//如果要return的话，要单独再叶子节点回溯
        }

        dfs(root.left, targetSum, list);
        dfs(root.right, targetSum, list);

        list.remove(list.size() - 1);
    }
}
