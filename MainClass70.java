//请看指剑offer第10题，有个大坑!!
//
//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}


//推荐 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

