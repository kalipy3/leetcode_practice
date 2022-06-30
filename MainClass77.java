/*
 * MainClass77.java
 * Copyright (C) 2022 2022-02-15 22:28 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//神仙题解 链接：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
//方法一
//送分题
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }
}


//kalipy一次过
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        dfs(n, k, new LinkedList<>(), 1);

        return ans;
    }

    private void dfs(int n, int k, List<Integer> list, int dept) {
        if (list.size() == k) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int i = dept; i <= n; i++) {
            list.add(i);
            dfs(n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
