//请对比200题

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

作者：edelweisskoko
链接：https://leetcode-cn.com/problems/max-area-of-island/solution/695-dao-yu-de-zui-da-mian-ji-dfs-bfsshua-oe8m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
