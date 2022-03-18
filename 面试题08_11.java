/*
 * 面试题08_11.java
 * Copyright (C) 2022 2022-02-16 14:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/* 推荐先看这个题解
链接：https://leetcode-cn.com/problems/coin-lcci/solution/gei-da-jia-kan-dian-shen-qi-de-dong-xi-pai-lie-yu-/
const int mod = 1000000007;
vector<int> dp(n+1, 1);
for(int j:vector<int>{5,10,25}){
    for(int i=1; i<=n; i++){
        if(i>=j){
            dp[i] = (dp[i] + dp[i-j])%mod;
        }
    }
}
return dp[n];

*/
//链接：https://leetcode-cn.com/problems/coin-lcci/solution/java-wan-quan-bei-bao-xiang-xi-ti-jie-yu-yi-bu-bu-/
class Solution {
    /**
     * 方法 1 ： 二维 dp 比较直观的解法
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];  // 一般多开一个位置，0 空着不用
        // base case
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                // 下面👇这部分代码是可以进一步改写的，因为从状态转移方程里面可以看到都有 dp[i-1][j],
                // 因此可以直接不用判断就赋值给 dp[i][j]，判断后再加上『 选择当前硬币时 』的补偿值就可以了

                if (j - coins[i-1] < 0){                   // 要组成的面值比当前硬币金额小，该硬币不可以选择
                    dp[i][j] = dp[i - 1][j] % 1000000007;  // 只能由 i - 1 中硬币来组成面值 j
                } else {
                    // 当前硬币可以不选，也可以选择
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i-1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    /**
     * 方法 2 ： 进一步一维 dp ，从状态转移方程可以看出，dp[i][j] 仅仅和 dp[i-1]的状态有关，所以可以压缩为 1 维
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}

