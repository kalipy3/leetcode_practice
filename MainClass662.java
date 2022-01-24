//官方题解 方法一
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}

//官方题解 方法二 kalipy修改后的
class Solution {
    int ans;
    List<Integer> left;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new LinkedList<>();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        //left.computeIfAbsent(depth, x-> pos);
        if (depth == left.size()) {
            left.add(pos);
        }
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}

//方法二的写法二
//思路: 用level 来记录当前所在的层数 ，从0开始
//      用一个list begins 来存储每一层的第一个元素。
//      因为是前序遍历，所以一定是先递归到该层的第一个元素
//      所以每一层只存第一个元素,只有level和list的size一致时才加入
//      if(level==begins.size()){
//      begins.add(index);
//      }
//      用该元素的下标减去和该元素在同一层的第一个元素的下标 再求最值，即得出结果
//      max = Math.max(max,index+1 - begins.get(level));
class Solution {
    private int max = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
          if(root==null){
            return 0;
        }
        preOrder(root,0,0,new ArrayList<>());
        return max;
    }

    private void preOrder(TreeNode root, int level, int index, List<Integer> begins){
        if(root==null){
            return;
        }
        //就把第一個遍歷到的索引加進去，也就是每層只加一個
        if(level==begins.size()){
            begins.add(index);
        }
        //那當前元素的下標減去該層首個元素的下標，並且一直求最大值，即可
        max = Math.max(max,index+1 - begins.get(level));
        preOrder(root.left,level+1,2*index,begins);
        preOrder(root.right,level+1,2*index+1,begins);
    }
}

