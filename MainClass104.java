//都是官方题解

//方法一
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

//方法一的写法二
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        //说明此时遍历到了底端
        if(root == null){
            return 0;
        }

        //当前结点最大深度 = 左右子树的最大深度+1
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}


//方法二 请打开下面注释，不然结果偏大，因为depth++正确应该是每次只加一次，但是注释掉for循环后虽然遍历顺序没变，但是depth在每一层会被多次++
class Solution {
    /**
     * 迭代法，使用层序遍历
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            //int size = deque.size();
            depth++;
            //for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            //}
        }
        return depth;
    }
}

