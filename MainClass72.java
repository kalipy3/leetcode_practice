/*
 * MainClass72.java
 * Copyright (C) 2022 2022-02-10 14:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

链接：https://leetcode-cn.com/problems/edit-distance/solution/dai-ma-sui-xiang-lu-72-bian-ji-ju-chi-do-y87e/

public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    // 初始化
    for (int i = 1; i <= m; i++) {
        dp[i][0] =  i;
    }
    for (int j = 1; j <= n; j++) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            // 因为dp数组有效位从1开始
            // 所以当前遍历到的字符串的位置为i-1 | j-1
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
    }
    return dp[m][n];
}


链接：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}


