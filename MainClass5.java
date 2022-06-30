//暴力破解
public boolean isPalindromic(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
public String longestPalindrome(String s) {
    String ans = "";
    int max = 0;
    int len = s.length();
    for (int i = 0; i < len; i++)
        for (int j = i + 1; j <= len; j++) {
            String test = s.substring(i, j);
            if (isPalindromic(test) && test.length() > max) {
                ans = s.substring(i, j);
                max = Math.max(max, ans.length());
            }
        }
    return ans;
}


作者：reedfan
链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法超
public String longestPalindrome(String s) {

    if (s == null || s.length() == 0) {
        return "";
    }
    int strLen = s.length();
    int left = 0;
    int right = 0;
    int len = 1;
    int maxStart = 0;
    int maxLen = 0;

    for (int i = 0; i < strLen; i++) {
        left = i - 1;
        right = i + 1;
        while (left >= 0 && s.charAt(left) == s.charAt(i)) {
            len++;
            left--;
        }
        while (right < strLen && s.charAt(right) == s.charAt(i)) {
            len++;
            right++;
        }
        while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
            len = len + 2;
            left--;
            right++;
        }
        if (len > maxLen) {
            maxLen = len;
            maxStart = left;
        }
        len = 1;
    }
    return s.substring(maxStart + 1, maxStart + maxLen + 1);

}



作者：carlsun-2
链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/dai-ma-sui-xiang-lu-5-zui-chang-hui-wen-zi0c6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//代码随想录
//布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
//kalipy补充:从下到上，从左到右遍历，且只遍历右上角(因为dp[i][j]的定义决定i<=j)
class Solution {
    public:
        string longestPalindrome(string s) {
            vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));
            int maxlenth = 0;
            int left = 0;
            int right = 0;
            for (int i = s.size() - 1; i >= 0; i--) {
                for (int j = i; j < s.size(); j++) {
                    if (s[i] == s[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i + 1 > maxlenth) {
                        maxlenth = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
            return s.substr(left, maxlenth);
        }
};



//从下到上，从左到右遍历，且只遍历右上角(因为dp[i][j]的定义决定i<=j)
//推荐
class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        String res = "";

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                System.out.println("i,j:"+i+"," +j);
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
            System.out.println("gg");
        }
        return res;
    }


}

