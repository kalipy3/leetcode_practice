/*
 * MainClass1155.java
 * Copyright (C) 2022 2022-03-17 16:56 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请先看这个题解 链接：https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/solution/dong-tai-gui-hua-bei-bao-wen-ti-yun-yong-axtf/
class Solution {
    int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int m, int t) {
        int[][] f = new int[n + 1][t + 1];
        f[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= n; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 0; j <= t; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int k = 1; k <= m; k++) {
                    if (j >= k) {
                        f[i][j] = (f[i][j] + f[i-1][j-k]) % mod;
                    }
                }
            }
        }
        return f[n][t];
    }
}

//方法二 dfs 也请掌握
class Solution {
    Integer[][] memo;
    final int MOD = (int)1e9 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        memo = new Integer[d + 1][target + 1];
        return dfs(d, f, target);
    }
    int dfs(int d, int f, int target) {
        if (d == 0 || target <= 0) return 0;
        if (d == 1) return target <= f ? 1 : 0;

        if (memo[d][target] != null) return memo[d][target];

        int ans = 0;
        for (int i = 1; i <= f; i++) {
            ans = (ans + dfs(d - 1, f, target - i)) % MOD;
        }
        
        return memo[d][target] = ans;
    }
}
