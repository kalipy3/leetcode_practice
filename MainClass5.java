import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//作者：yi-fang-65
//链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/java-dong-tai-gui-hua-chao-jian-ji-de-da-l9pa/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        String res = "";

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


}

public class MainClass5 {
    public static void main(String[] args) throws IOException {
            String s = "abcbd";

            String ret = new Solution().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
    }
}
