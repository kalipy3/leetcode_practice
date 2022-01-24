//注意:你可以假设树中没有重复的元素。


//根据前序和中序可以构造一颗二叉树，根据中序和后续也可以构建一颗二叉树。 反正必须要有中序才能构建，因为没有中序，你没办法确定树的形状。 比如先序和后序是不能构建唯一的一颗二叉树的。 例如： 先序为：[1, 2] 后序为：[2, 1]
//
//可以构建如下
//
//    1
//   / 
//  2  
//
//    1
//     \
//      2  
//
//这个面试官也会问的
//

作者：reals
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//写法二 推荐
class Solution {

    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}


//写法三
class Solution {
    Map<Integer, Integer> hashmap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (!hashmap.containsKey(inorder[i])) {
                hashmap.put(inorder[i], i);
            }
        }
        return dfs(inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
    }

    // 中序遍历的(子)树的左右区间 [l, r] 与后序遍历的根结点索引 root_idx
    public TreeNode dfs(int[] inorder, int[] postorder, int l, int r, int root_idx) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[root_idx]); // 后序遍历的根root
        int idx = hashmap.get(postorder[root_idx]); // 后序遍历的根root在中序遍历中的索引

        int rightTree_root_idx = root_idx - 1; // 后序遍历中, root的右子树的根索引
        int leftTree_root_idx = root_idx - (r - idx) - 1; // 后序遍历中, root的左子树的根索引为 其父结点索引 - 右子树长度 - 1

        root.left = dfs(inorder, postorder, l, idx - 1, leftTree_root_idx);
        root.right = dfs(inorder, postorder, idx + 1, r, rightTree_root_idx); // 两行可以互换
        return root;
    }
}
