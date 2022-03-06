//kalipy的错误解法
//2
//3 4
//6 5 7
//4 1 8 3

//此反例证明了贪心解法不可取，即局部最优解不能推出全局最优解
//-1+3+-3  = -1
//-1
//2   3
//1   -1  -3
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = triangle.get(0).get(0);

        int pre = 0;
        for (int i = 1; i < triangle.size(); i++) {
            ans += Math.min(triangle.get(i).get(pre), triangle.get(i).get(pre+1));    

            if (triangle.get(i).get(pre) > triangle.get(i).get(pre+1)) {
                pre = pre+1;
            }
        }


        return ans;
    }
}

https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/

//方法一 超时
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
}

//方法二 记忆化 ok
class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
}

//方法二 记忆化 写法二 kalipy ok 推荐
class Solution {
    Integer[][] mem;
    public int minimumTotal(List<List<Integer>> triangle) {
        mem = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int dept, int col) {
        if (triangle.size()-1 == dept) {
            return triangle.get(dept).get(col);
        }

        if (mem[dept][col] != null) return mem[dept][col];

        int l = dfs(triangle, dept+1, col);
        int r = dfs(triangle, dept+1, col+1);
        int ret = Math.min(l, r) + triangle.get(dept).get(col);
        mem[dept][col] = ret;
        return ret;
    }
}

//方法三 推荐
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];//是为了给最后一行的下一行初始化为0
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
            //for (int j = i; j >= 0; j--) {//也ok
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

//状态压缩
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}







// 回溯算法
class Solution {
    public:
        int helper(vector<vector<int>>& triangle, int row, int col) {
            if (triangle.size() - 1 == row) {
                return triangle[row][col];
            }

            int down = helper(triangle, row + 1, col);
            int right = helper(triangle, row + 1, col + 1);

            return min(down, right) + triangle[row][col];
        }
        int minimumTotal(vector<vector<int>>& triangle) {
            return helper(triangle, 0, 0);
        }
};

// 回溯算法-备忘录
class Solution {
    public:
        int helper(vector<vector<int>>& triangle, vector<vector<int>>& mem, int row, int col) {
            if (triangle.size() - 1 == row) {
                return triangle[row][col];
            }
            if (mem[row][col]) return mem[row][col];

            int down = helper(triangle, mem, row + 1, col);
            int right = helper(triangle, mem, row + 1, col + 1);

            int ret = min(down, right) + triangle[row][col];
            mem[row][col] = ret;
            return ret;
        }
        
        int minimumTotal(vector<vector<int>>& triangle) {
            int len = triangle.size();
            if (len == 0) return 0;
            vector<vector<int>> mem(len, vector<int>(len));
            return helper(triangle, mem, 0, 0);
        }
}
