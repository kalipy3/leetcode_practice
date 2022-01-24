//官方题解
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

//dfs写法二 推荐
//class Solution {
//    public:
//        int sumOfLeftLeaves(TreeNode* root) {
//            if(root==NULL) return 0;
//            int result=0;
//            int mid=0;
//            if(root->left!=NULL&&root->left->left==NULL&&root->left->right==NULL) mid=root->left->val;
//            int left=sumOfLeftLeaves(root->left);
//            int right=sumOfLeftLeaves(root->right);
//            result=mid+left+right;
//            return result;
//        }
//};

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


