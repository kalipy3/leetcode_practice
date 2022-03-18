/*
 * MainClass931.java
 * Copyright (C) 2022 2022-02-17 00:05 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过 送分题

//写法一 推荐
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if (n == 1) return arr[0][0];
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<n;i++) {
            for (int j = 0;j < n;j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else if (j == 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j],dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j],dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i - 1][j + 1]));
                }
                if (i == n - 1) {
                    min = Math.min(min,dp[i][j]);
                }
            }
        }
        return min;
    }
}

//写法二
/*
var minFallingPathSum = function (matrix) {
  let n = matrix.length;
  let res = Number.MAX_SAFE_INTEGER;
  const initVal = 66666;
  let memo = new Array(n).fill(initVal).map(() => new Array(n).fill(initVal));
  let dp = (matrix, i, j) => {
    // 非法索引检查
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
      // 对于索引越界的dp函数，应该返回一个不可能被取到的值。
      return 99999;
    }
    // base case
    if (i == 0) {
      return matrix[i][j];
    }
    // 查找备忘录，防止重复计算
    if (memo[i][j] != initVal) {
      return memo[i][j];
    }
    // 状态转移
    memo[i][j] =
      matrix[i][j] +
      Math.min(
        // i - 1, j - 1, j + 1这几个运算可能会造成索引越界，对于索引越界的dp函数，应该返回一个不可能被取到的值
        dp(matrix, i - 1, j),
        dp(matrix, i - 1, j - 1),
        dp(matrix, i - 1, j + 1)
      );
    return memo[i][j];
  };
  // 终点可能在最后一行的任意一列
  for (let j = 0; j < n; j++) {
    res = Math.min(res, dp(matrix, n - 1, j));
  }
  return res;
};

*/

//kalipy一次过 推荐
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if (n == 1) return arr[0][0];
        int[][] dp = new int[n+1][n+1];
        //Arrays.fill(dp, Integer.MAX_VALUE / 2);
        for(int i=1; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j <= n;j++) {
                if (j == n) {
                    dp[i][j] = arr[i-1][j-1] + Math.min(dp[i - 1][j],dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = arr[i-1][j-1] + Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i - 1][j + 1]));
                }

                if (i == n) {
                    min = Math.min(min,dp[i][j]);
                }
            }
        }
        return min;
    }
}
