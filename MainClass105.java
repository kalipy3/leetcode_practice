//请先看官方视频讲解
//
public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
}

private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                                 HashMap<Integer, Integer> map) {
    if (p_start == p_end) {
        return null;
    }
    int root_val = preorder[p_start];
    TreeNode root = new TreeNode(root_val);
    int i_root_index = map.get(root_val);
    int leftNum = i_root_index - i_start;
    root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
    root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
    return root;
}


作者：windliang
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
