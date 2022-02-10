//方法一 dfs
https://leetcode-cn.com/problems/interleaving-string/solution/shou-hua-tu-jie-dfshui-su-dfsji-yi-hua-by-hyj8/
//js
/*
 *
const isInterleave = (s1, s2, s3) => {
    if (s1.length + s2.length != s3.length) return false;

    const check = (i, j, k) => { // 检查ijk开始的子串是否满足题目条件
        // k越界，s3扫描完了，返回true
        if (k == s3.length) return true;       

        let isValid = false;                   
        // i指针没有越界，且s1[i]和s3[k]相同
        if (i < s1.length && s1[i] == s3[k]) { 
            isValid = check(i + 1, j, k + 1);    // i、k右移一位，递归考察
        }
        // j 指针没有越界，且s2[i]和s3[k]相同
        if (j < s2.length && s2[j] == s3[k]) { 
            isValid = isValid || check(i, j + 1, k + 1); 
            // 有可能i、j、k指向相同的字符，尝试 i、k 右移，但已经做过了
            // isValid 就是 check(i + 1, j, k + 1) 的结果
            // 如果它为true，就不用执行 j、k 右移的递归(因为之前已经if (s1.length + s2.length != s3.length) return false;，如果s1和s3相等，则s2必为""字符串)，如果是false，执行递归
        }
        return isValid; // 整个遍历过程都没有返回true，则返回默认的false
    };

    return check(0, 0, 0);
};

*/

//java 记忆化dfs
class Solution {
    int l1, l2, l3;
    String s1, s2, s3;
    boolean[][] visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        if (l1 + l2 != l3)  return false;
        visited = new boolean[l1 + 1][l2 + 1];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        return dfs(0, 0, 0);
    }
    private boolean dfs(int i, int j, int k) {
        if (k == l3)    return true;
        if (visited[i][j])  return false;
        visited[i][j] = true;
        if (i < l1 && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1))         return true;   
        if (j < l2 && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1))         return true;
        return false;
    }
}




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


