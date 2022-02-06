//作者：yuanyb
//链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/hen-jian-dan-de-si-lu-dai-ma-hen-jian-ji-by-yuanyb/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法一
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null)
                return false;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }
}

//方法三
//对于一个完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reachedEnd = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(reachedEnd && cur != null){
                return false;
            }
            if(cur == null){
                reachedEnd = true;
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }




//作者：lin-shen-shi-jian-lu-k
//链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/yan-du-you-xian-sou-suo-zui-jian-ji-yi-d-oqga/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法二 原作者的写法
class Solution {
    int n = 0, p = 0; 
    public boolean isCompleteTree(TreeNode root) {
        if(!dfs(root,1)) return false;
        return n == p;
    }
    public boolean dfs(TreeNode root , int k) //k是当前节点编号
    {
        if(root == null) return true;  //递归到了叶子节点
        if(k > 100) return false;
        n++;  p = Math.max(p,k); //记录节点数和最大节点编号值
        return dfs(root.left,2*k)&&dfs(root.right,2*k + 1); //递归左右子树
    }
}
//方法二的kalipy写法(因为递归的过程中根本判断不了是不是完全二叉树，只有递归结束后n和p都收集完毕才能根据n和p来判断)
class Solution {
    int n = 0, p = 0; 
    public boolean isCompleteTree(TreeNode root) {
        dfs(root,1);
        return n == p;
    }
    public void dfs(TreeNode root , int k) //k是当前节点编号
    {
        if(root == null) return;  //递归到了叶子节点
       
        n++;  p = Math.max(p,k); //记录节点数和最大节点编号值 //此行代码在dfs()的前中后都行
        dfs(root.left,2*k);
        dfs(root.right,2*k + 1); //递归左右子树
    }
}

