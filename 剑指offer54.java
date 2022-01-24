作者：lin-shen-shi-jian-lu-k
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/zui-jian-jie-yi-dong-de-dai-ma-tu-wen-bi-spxa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    int res;
    int index = 0; //计数器
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    void dfs(TreeNode root ,int k) 
    {
        if(root == null) return;
        dfs(root.right,k); //右
        index++;
        if(k == index) {
            res = root.val; //根
            return;
        } 
        
        dfs(root.left,k); //左
    }
}

