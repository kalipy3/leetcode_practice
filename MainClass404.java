
//写法三 推荐 kalipy
class Solution {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
       dfs(root);
       return ans;
    }
   
   public void dfs(TreeNode root) {
       if (root == null) return;

       if (root.left!=null && root.left.left==null && root.left.right==null) {
           ans += root.left.val;
       }

        dfs(root.left);
        dfs(root.right);
   }

}


//方法二 推荐
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}



