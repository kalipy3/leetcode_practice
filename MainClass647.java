//推荐方法二 不易错


//方法一 推荐写法二
作者：carlsun-2
链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-vidge/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public:
        int countSubstrings(string s) {
            vector<vector<bool>> dp(s.size(), vector<bool>(s.size(), false));
            int result = 0;
            for (int i = s.size() - 1; i >= 0; i--) {  // 注意遍历顺序
                //注意第二个for不是int j=0!!!!!!!代码随想录的遍历顺序分析有问题，建议看下面的写法二题解中的遍历顺序分析
                for (int j = i; j < s.size(); j++) {
                    if (s[i] == s[j]) {
                        if (j - i <= 1) { // 情况一 和 情况二
                            result++;
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) { // 情况三
                            result++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return result;
        }
};

//写法二
https://leetcode-cn.com/problems/palindromic-substrings/solution/shou-hua-tu-jie-dong-tai-gui-hua-si-lu-by-hyj8/
class Solution {
    public int countSubstrings(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                //注意j - i < 2 一定要写在 dp[i + 1][j - 1]的前面，不然dp[i+1][j-1]越界异常
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}


//方法二
//作者：jawhiow
//链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    int num = 0;
    public int countSubstrings(String s) {
        for (int i=0; i < s.length(); i++){
            count(s, i, i);//以i为中心
            count(s, i, i+1);//以i和i+1为中心
        }
        return num;
    }

    public void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }
}
