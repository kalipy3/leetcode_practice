/*
 * MainClass1312.java
 * Copyright (C) 2022 2022-03-18 15:26 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区 推荐
class Solution {

    private Integer[][] cache;

    private char[] chars;

    public int minInsertions(String s) {
        int len = s.length();
        cache = new Integer[len][len];
        chars = s.toCharArray();
        return dfs(0, len - 1);
    }

    private int dfs(int from, int to) {
        if (from >= to) {//eg:"a"，已经是回文，不用插入
            return 0;
        }
        if (cache[from][to] != null) {
            return cache[from][to];
        }
        if (chars[from] == chars[to]) {
            return dfs(from + 1, to - 1);
        }
        return cache[from][to] = Math.min(dfs(from + 1, to), dfs(from, to - 1)) + 1;//eg:"ab"，不是回文，要插入，考虑分别在a的左边插入b和在b的右边插入a
    }
}

//方法二 推荐
/*
换个角度想:当前字符串要变成回文,那只要把不一样的找出来就好了.即:求出反过来的字符串和当前字符串的最长公共子序列,然后减一下.

如 : "ab" --> reverse  ---> "ba",
"ab"和"ba"的 最长公共子序列长度是 1, 即 len("ab") = 2,  2 - 1 = 1, 即 只要插入1个字母就好咯. "aba" 或者"bab".
如 leetcode 和
     edocteel 的最长公共子序列是  e t e ,长度为3,  即 8-3 = 5.
把公共部分保持不变,其他的插过来,或者插过去,就一样啦!
*/
class Solution {
    public int minInsertions(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        int common = longestCommonSubsequence(s, rs);
        return s.length() - common;
    }
    
    private int longestCommonSubsequence(String str1, String str2) {
        final int m = str1.length(), n = str2.length();
        // str1[0...m-1]和str2[0...n-1]的公共序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

