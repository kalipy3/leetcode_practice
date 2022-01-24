//推荐写法二

//作者：CelesteZephyr
//链接：https://leetcode-cn.com/problems/number-of-closed-islands/solution/1254-tong-ji-feng-bi-dao-yu-de-shu-mu-sh-e1e9/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//本题思路：循环遍历二维数组寻找新岛屿的陆地，再从该陆地出发深度优先遍历判断其所在岛屿是否为封闭岛屿
//
//    当遇到新岛屿的陆地时，将当前临时封闭岛屿数量val置1。
//    从该块陆地出发，利用深度优先遍历找到该岛屿内的其他陆地并标记为非陆地（陆沉，避免下次重复计算），若遍历到矩阵边界则说明为非封闭岛屿，将当前临时封闭岛屿数目val置0。
//    更新封闭岛屿数目。

class Solution {
    private int val;
    public int closedIsland(int[][] grid) {
        int closedLandNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    val = 1;
                    dfs(grid, i, j);
                    closedLandNum += val;
                }
            }
        }
        return closedLandNum;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            val = 0;
            return;
        }
        if(grid[i][j] != 0) return;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

//写法二
class Solution {
    int m;
    int n;
    int[][] grid;
    int count = 0;
    public int closedIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) {
                    if(DFS(i,j)) count++;
                }
            }
        }
        return count;
    }

    private boolean DFS(int i,int j){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        if(grid[i][j]==0){
            grid[i][j] = 1;
            boolean up = DFS(i-1,j);
            boolean down = DFS(i+1,j);
            boolean left = DFS(i,j-1);
            boolean right = DFS(i,j+1);
            return (up && down && left && right);
        }
        return true;    
    }
}
