递归和非递归两种思路

1.非递归，BST中序遍历是有序的，我们只要对树进行中序遍历即可，利用一个前驱节点prev，记录上一个被处理的节点，当前节点被遍历到的时候，将prev.right指向当前节点node，然后node.left置空，prev指针后移到node,最后node进入右子树即可。

2.递归，思路基本与非递归相同，不过要注意的是递归之后的prev指针要返回，因为JAVA中是没有引用传递的，左子树递归回来之后，当前的prev指针没有发生改变，还是外部传进来的那个哨兵节点，这个时候一旦进入右子树，之前的prev.right指针将会被重置。也就说，root的左子树操作全部失效了。

//方法一
public TreeNode convertBiNode(TreeNode root) {
    TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
    TreeNode prev = head;// 移动的链表前置指针
    // 开始中序遍历
    TreeNode node = root;
    Deque<TreeNode> stack = new LinkedList<>();
    while (node != null || !stack.isEmpty()){
        if (node != null){
            stack.push(node);
            node = node.left;
        }else {
            node = stack.pop();
            // ---链表处理
            node.left = null;// 左指针置空
            prev.right = node;// 右指针作为链表的next指针
            prev = node;// 指针后移
            // ---链表处理
            // 中序遍历进入右子树
            node = node.right;
        }
    }
    return head.right;
}



//方法二
class Solution {
    TreeNode head=new TreeNode(-1);
    TreeNode pre=head;
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root==null)
            return;
        helper(root.left);
        pre.right=root;
        pre=root;
        root.left=null;
        helper(root.right);
    }
}
