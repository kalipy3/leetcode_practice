//java 推荐 请直接看代码，可以看懂的
class Solution {
    /**
     * 二叉树的最近公共祖先
     * 思路：
     * 三种情况：
     * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
     * 2、p q 都在左子树 
     * 3、p q 都在右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }
}

//c
class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == NULL)
                return NULL;
            if(root == p || root == q) 
                return root;

            TreeNode* left =  lowestCommonAncestor(root->left, p, q);
            TreeNode* right = lowestCommonAncestor(root->right, p, q);

            if(left == NULL)
                return right;
            if(right == NULL)
                return left;      
            if(left && right) // p和q在两侧
                return root;

            return NULL; // 必须有返回值
        }
};



作者：Wilson79
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
