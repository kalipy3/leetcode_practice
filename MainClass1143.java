/*
 * MainClass1143.java
 * Copyright (C) 2022 2022-02-14 17:53 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//写法一
//链接：https://leetcode-cn.com/problems/longest-common-subsequence/solution/gong-shui-san-xie-zui-chang-gong-gong-zi-xq0h/
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        s1 = " " + s1; s2 = " " + s2;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int[][] f = new int[n + 1][m + 1]; 

        // 因为有了追加的空格，我们有了显然的初始化值（以下两种初始化方式均可）
        // for (int i = 0; i <= n; i++) Arrays.fill(f[i], 1);
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int j = 0; j <= m; j++) f[0][j] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i] == cs2[j]) {
                    f[i][j] = f[i -1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        // 减去最开始追加的空格
        return f[n][m] - 1;
    }
}


//写法二
//链接：https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-tu-jie-dpz-6mvz/
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


