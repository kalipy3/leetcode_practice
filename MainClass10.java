//官方题解
//kalipy解释:这里的匹配是指s和p要完全一样
//方法一
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}




//方法二
//作者：lala-333
//链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//最后来个归纳：
//
//    1. 如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
//    2. 如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
//    3. 如果 p.charAt(j) == '*'：
//        1. 如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
//        2. 如果 p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.'：
//            dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
//            or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
//            or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
public boolean isMatch(String s,String p){
    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
    for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
        if (p.charAt(i) == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true; // here's y axis should be i+1
        }
    }
    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                dp[i + 1][j + 1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                } else {
                    dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    /*
                       dp[i][j] = dp[i-1][j] // 多个字符匹配的情况	
                       or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                       or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                       */

                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
