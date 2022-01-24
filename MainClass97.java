https://leetcode-cn.com/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/


//写法一
public static boolean isInterleave(String str1, String str2, String str3) {
    int n = str1.length();
    int m = str2.length();
    if (str3.length() != n + m) return false;
    // dp[i][j]：s1前缀长度i + s2前缀长度j，能否交错组成s3前缀长度i+j
    boolean[][] dp = new boolean[n+1][m+1];
    char[] s1 = str1.toCharArray(), s2 = str2.toCharArray(), s3 = str3.toCharArray();
    dp[0][0] = true;
    // 第0行：s1前缀长度0 + s2前缀长度i，能否交错组成s3前缀长度i
    for (int i = 1; i <= m; i++) {
        dp[0][i] = dp[0][i-1] && s2[i - 1] == s3[i - 1];
    }
    // 第0列：s1前缀长度i + s2前缀长度0，能否交错组成s3前缀长度i
    for (int i = 1; i <= n; i++) {
        dp[i][0] = dp[i-1][0] && s1[i - 1] == s3[i - 1];
    }
    // 普通位置 dp[i][j]：s1前缀长度i + s2前缀长度j，能否交错组成s3前缀长度i+j
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            // 考虑s3的最后一个字符s3[i+j-1]来自哪里？做状态转移：
            // 1）如果来自s1[i-1]，则dp[i][j] 为：s1前缀长度i-1 + s2前缀长度j 能否交错组成s3前缀长度i+j-1，即：dp[i-1][j]
            // 2）如果来自s2[j-1]，则dp[i][j] 为：s1前缀长度i + s2前缀长度j-1 能否交错组成s3前缀长度i+j-1，即：dp[i][j-1]
            dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]) ||
                (s2[j-1] == s3[i+j-1] && dp[i][j-1]);
        }
    }

    return dp[n][m];
}


作者：antione
链接：https://leetcode-cn.com/problems/interleaving-string/solution/you-bao-li-hui-su-dao-ji-yi-hua-fen-xiang-wo-de-do/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//状态定义
//
//令dp[i][j]为字符子串s1[0, i),s2[0, j)能否组成s3[0, i+j)。
//ps: s1[0, i) = s1.substring(0, i),不包含i。
//
//    对于字符串的状态dp[i]来说，通常要考虑所有子串的长度[0, n]，因此定义dp[n+1],n是字符串s的长度，同理二维也一样。
//
//对于dp[i][j]该状态来说，要想组成s3[0,i+j)，其s3[0, i+j)最后一个字符s3[i+j-1]要么来自s1[i-1], 要么来自s2[j-1],因此，状态转移：
//
//    若s1[i-1]==s3[i+j-1]：
//
//dp[i][j]=dp[i−1][j],i>0dp[i][j] = dp[i-1][j],i > 0 dp[i][j]=dp[i−1][j],i>0
//
//    若s2[j-1]==s3[i+j-1]：
//
//dp[i][j]=dp[i][j−1],j>0dp[i][j] = dp[i][j-1],j >0 dp[i][j]=dp[i][j−1],j>0
//
//状态初始化：dp[0][0] = true，表示两个空字符串能够组成一个空字符串。
//写法二
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        if(s3 == null) s3 = "";

        int n = s1.length(), m = s2.length();
        if(n + m != s3.length())
            return false;

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i > 0){
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if(j > 0){
                    dp[i][j] |= (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }

        return dp[n][m];
    }
}


