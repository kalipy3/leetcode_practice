/*
 * MainClass1143.java
 * Copyright (C) 2022 2022-02-14 17:53 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//写法二
//链接：https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-tu-jie-dpz-6mvz/

//若text1[i] != text2[j]，也就是说两个字符串的最后一位不相等，那么字符串text1的[1,i]区间和字符串text2的[1,j]区间的最长公共子序列长度无法延长，因此f[i][j]就会继承f[i-1][j]与f[i][j-1]中的较大值，即f[i][j] = max(f[i - 1][j],f[i][j - 1]) 。 （ 下标从1开始）
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m =  text2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}


