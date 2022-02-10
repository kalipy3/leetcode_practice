/*
 * MainClass516.java
 * Copyright (C) 2022 2022-02-10 14:21 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */


//链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-3/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}


//https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-dv83q/
