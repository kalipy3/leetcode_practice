//官方题解 dfs+回溯 推荐写法二
class Solution {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}


//写法二 last隐式回溯
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int max = 0;
        //遍历每一个元素，计算以其为起点的递增路径的长度，计其中的最大长度为max
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(visited, matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    //从当前matrix[i][j]出发能够得到的最长递增路径长度
    //注意:last是preMatrix[i][j],不是最长路径的意思
    public int dfs(int[][] visited, int[][] matrix, int i, int j, int last){
        //从当前节点出发的路径已达边界或当前值小于上一值，返回0
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= last){
            return 0;
        }
        //以matrix[i][j]为起点的最长升序路径长度：已经求过，直接返回
        if(visited[i][j] > 0) return visited[i][j];

        //当前元素值满足条件，进行DFS搜索 
        last = matrix[i][j];
        int l = dfs(visited, matrix, i + 1, j, last);
        int r = dfs(visited, matrix, i - 1, j, last);
        int u = dfs(visited, matrix, i, j + 1, last);
        int d = dfs(visited, matrix, i, j - 1, last);
        //选取最长递增路径长度
        visited[i][j] = 1 + Math.max(Math.max(l, r), Math.max(u, d));
        //返回结果
        return visited[i][j];
    }
}

//kalipy 写法三 last显式回溯
class Solution {
    List<Integer> list = new LinkedList<>();

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int max = 0;
        //遍历每一个元素，计算以其为起点的递增路径的长度，计其中的最大长度为max
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(visited, matrix, i, j));
            }
        }
        return max;
    }
    //从当前matrix[i][j]出发能够得到的最长递增路径长度
    public int dfs(int[][] visited, int[][] matrix, int i, int j){

        
        //从当前节点出发的路径已达边界或当前值小于上一值，返回0
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || (list.size()!=0 && matrix[i][j] <= list.get(list.size()-1))){
            return 0;
        }
        //以matrix[i][j]为起点的最长升序路径长度：已经求过，直接返回
        if(visited[i][j] > 0) return visited[i][j];

        //当前元素值满足条件，进行DFS搜索 
        list.add(matrix[i][j]);
        int l = dfs(visited, matrix, i + 1, j);
        int r = dfs(visited, matrix, i - 1, j);
        int u = dfs(visited, matrix, i, j + 1);
        int d = dfs(visited, matrix, i, j - 1);
        list.remove(list.size()-1);
        //选取最长递增路径长度
        visited[i][j] = 1 + Math.max(Math.max(l, r), Math.max(u, d));
        //返回结果
        return visited[i][j];
    }
}
