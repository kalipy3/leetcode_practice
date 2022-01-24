//kalipy一次过
//方法一
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

//方法一空间优化
//优化思路理解参考一:
//优化一：由于dp[i][j] = dp[i-1][j] + dp[i][j-1]，因此只需要保留当前行与上一行的数据 (在动态方程中，即pre[j] = dp[i-1][j])，两行，空间复杂度O(2n)；
//优化二：cur[j] += cur[j-1], 即cur[j] = cur[j] + cur[j-1] 等价于思路二-->> cur[j] = pre[j] + cur[j-1]，因此空间复杂度为O(n).


//优化思路理解参考二:
//令m为行、n为列 优化1：行列两层循环中的循环体cur[j] = pre[j] + cur[j-1] ，cur[j] 表示遍历到的从起点到第i行第j列的路径数，它等于当前第i行第j-1列即 cur[j-1]的值 加上 上一行第j列的值pre[j] 内层循环一次后即计算完了第i行各列的值，在计算下一行第i+1行之前执行pre = cur.clone(); 即第i行的值就是第i+1行的前一行，两层循环完以后最后要到达的终点的行的值存于pre数组中，所以取出 pre[n-1]即可
//
//优化2：相比优化1，少了pre数组，cur[j] += cur[j-1] 即 cur[j] = cur[j-1] + cur[j] 未赋值之前右边的cur[j] 始终表示当前行第i行的上一行第j列的值，赋值之后左边的cur[j]表示当前行第i行第j列的值，cur[j-1] 表示当前行第i行第j-1列的值(cur[j-1] 在计算cur[j]之前就已经计算了，所以表示的是当前行而不是上一行 )， 思路跟优化1是一样的，除了少用了一个数组

//方法二 官方题解
class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}



