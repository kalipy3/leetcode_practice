public static void preOrderIteration(TreeNode head) {
	if (head == null) {
		return;
	}
	Stack<TreeNode> stack = new Stack<>();
	stack.push(head);
	while (!stack.isEmpty()) {
		TreeNode node = stack.pop();
		System.out.print(node.value + " ");
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			stack.push(node.left);
		}
	}
}


作者：gre-z
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//官方题解
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}


