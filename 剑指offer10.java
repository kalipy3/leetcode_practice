//正确解法  注意:%1000000007一定要写在for里面
class Solution {
    public int numWays(int n) {
        int[] dp = new int[n+1];
        if (n == 0) return 1;
        if (n == 1) return 1;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}

//错误解法 注意:%1000000007一定要写在for里面
class Solution {
    public int numWays(int n) {
        int[] dp = new int[n+1];
        if (n == 0) return 1;
        if (n == 1) return 1;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n] % 1000000007;
    }
}

//写法二
class Solution {
    public int numWays(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int c = 3;
        for (int i = 3; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
