
//推荐这个题解
//链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
public class Solution {

    // 做加法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }
}





//请看MainClass_22_dfs.png和MainClass_22_dfs2.png
//作者：lin-shen-shi-jian-lu-k
//链接：https://leetcode-cn.com/problems/generate-parentheses/solution/shen-du-you-xian-bian-li-zui-jian-jie-yi-ypti/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//dfs写法一(str是局部变量，所以回溯不用撤销操作)
class Solution {
    static List<String> res = new ArrayList<String>();  //记录答案 

    public List<String> generateParenthesis(int n) {
        res.clear();
        dfs(n, 0, 0, "");
        return res;
    }
    public void dfs(int n ,int lc, int rc ,String str)
    {
        if( lc == n && rc == n) res.add(str);   //递归边界
        else
        {
            if(lc < n) dfs(n, lc + 1, rc, str + "(");
            if(rc < n && lc > rc) dfs(n, lc, rc + 1, str + ")");
        }
    }
}


//dfs写法二(str是全局变量，全程只有一份，所以回溯时要撤销进行回溯)
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        StringBuilder path = new StringBuilder();
        dfs(path, n, n, res);
        return res;
    }


    /**
     * @param path  从根结点到任意结点的路径，全程只使用一份
     * @param left  左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param res
     */
    private void dfs(StringBuilder path, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
            res.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

//方法二 BFS
//作者：liweiwei1419
//链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution {

    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }
}

//kalipy改进：
if (curNode.right > 0 && curNode.left < curNode.right && curNode.res.charAt(0) != ')')//78行可以把一开始level1的")"剪掉
