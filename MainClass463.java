/*
 * MainClass463.java
 * Copyright (C) 2022 2022-01-28 15:40 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//链接：https://leetcode-cn.com/problems/island-perimeter/solution/tu-jie-jian-ji-er-qiao-miao-de-dfs-fang-fa-java-by/
//送分题

//评论区 推荐
class Solution {
    // 把每一条边都加起来，其中，边分为2类：一种是在grid边缘的，另一种是和湖接壤的（就是dfs回溯的那条）
    public int islandPerimeter(int[][] grid) {
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 1 ) {
                    // 题目保证一定会存在一个岛屿
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int i, int j) {
        // 走到了边缘
        if ( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ) {
            return 1;
        }
        // 走到了湖泊
        if ( grid[i][j] == 0 ) {
            return 1;
        }
        // 走到了已经访问过的
        if ( grid[i][j] == 2 ) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
    }
}

//kalipy一次过
class Solution {
    int ans = 0;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            ans++;
            return;
        }

        if (grid[i][j] == 2) return;

        grid[i][j] = 2;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
