/*
 * MainClass1277.java
 * Copyright (C) 2022 2022-01-30 20:50 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
class Solution {
    public int countSquares(int[][] matrix) {

        int ans = 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    //dp[i][j] = 0;//没有也ok
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;

                } 

                ans += dp[i][j];
            }
        }
        return ans;
    }
}
