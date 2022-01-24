//先看这个题解描述

//作者：z1m
//链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/dong-tai-gui-hua-dp-by-z1m/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//写法一
//dp(i) 表示前 i 个数字的翻译方法数
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i ++){
            String temp = s.substring(i-2, i);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                dp[i] = dp[i-1] + dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
}

//写法二
public int translateNum2(int num) {
    String s = String.valueOf(num);
    int[] dp = new int[s.length()];
    dp[0] = 1;
    for (int i = 1; i < s.length(); i++) {
        String temp = s.substring(i - 1, i + 1);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
            if (i == 1) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        } else {
            dp[i] = dp[i - 1];
        }
    }
    return dp[s.length() - 1];
}

//写法三
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}

//写法四
//作者：jyd
//链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}

//方法二 dfs
//作者：z1m
//链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/dong-tai-gui-hua-dp-by-z1m/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
public:
    int backtrack(string& s, int idx){
        int n = s.size();
        if(idx == n) return 1;
        if(idx == n - 1 || s[idx] == '0' || s.substr(idx, 2) > "25")
            return backtrack(s, idx + 1);
        return backtrack(s, idx + 1) + backtrack(s, idx + 2);
    }
    int translateNum(int num) {
        string s = to_string(num);
        return backtrack(s, 0);
    }
};




