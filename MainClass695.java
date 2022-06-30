//请对比200题
//送分题

//请直接看代码即可
//方法一
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }   
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}

//kalipy一次过
class Solution {
    int ans = 0;
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                dfs(grid, i, j);
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || j > grid[0].length-1 || i > grid.length-1 || j < 0 || grid[i][j] == 0) return;

        sum += grid[i][j];
        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);

        ans = Math.max(ans, sum);
    }
}
