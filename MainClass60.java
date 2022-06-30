/*
 * MainClass60.java
 * Copyright (C) 2022 2022-02-15 21:59 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//神仙题解 https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
import java.util.Arrays;

public class Solution {

    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}

//kalipy一次过
class Solution {
    //List<String> list = new LinkedList<>();
    boolean[] visited = new boolean[1000000];
    int n;
    int k;
    String ans = "";
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(0, new StringBuilder());
        //for (String str : list) {
        //    System.out.println(str);
        //}
        return ans;
    }

    private void dfs(int dept, StringBuilder sb) {
        if (dept == n) {
            //list.add(sb.toString());
            k--;
            if (k == 0) {
                ans = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i + "");
                dfs(dept + 1, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
