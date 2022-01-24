推荐先看本文件的思路和代码，看懂后再看这个链接:
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/che-di-chi-tou-shu-de-qian-zhong-hou-xu-di-gui-fa-/

请对比590题

//先说说主要思路：
//
//    循环加入左子节点，pop出，如果该节点右子树为空或者已经访问过了才访问根结点
//    否则，就不能去访问根节点，那么将该结点再次压回栈中，去访问其右子树，重复上述步骤
//    当然，如果访问过了或者没有右子树，那么就可以加入到list中，再去访问根节点
//    这样就实现了左——右——根，如果右子树没有或者已经访问过才能去访问根结点

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;//记录前一个访问的结点

        while(root!=null || !stack.isEmpty()){
            //循环加入左子节点
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            //如果没有右子节点，或者右子节点已经访问过了
            if(root.right==null || root.right==pre){
                list.add(root.val);
                pre = root;//更新
                root = null;//让root=null，代表这个节点使用完毕，那么下一次就是root = stack.pop();
            }else{
                stack.push(root);//放入栈中
                root = root.right;//访问右子树
            }     
        }
        return list;
    }
}

//kalipy
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> st = new LinkedList<>();

        TreeNode pre = null;
        while (root!=null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            TreeNode cur = st.pop();
            if (cur.right==null || cur.right==pre) {
                ans.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                st.push(cur);
                root = cur.right;
            }
        }

        return ans;
    }
}
