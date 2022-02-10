/*
 * MainClass343.java
 * Copyright (C) 2022 2022-02-09 10:12 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解 
//dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}

//kalipy写法二
class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), dp[i-j]*j));
            }
        }

        return dp[n];
    }
}
