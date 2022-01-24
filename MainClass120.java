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

方法一
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

//方法二
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

//方法三
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
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



