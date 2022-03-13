//官方题解 方法二
//那个动态规划法，我觉得换一种解释能更清晰一点儿：
//
//相当于3个数组，分别是能被2、3、5整除的递增数组，且每个数组的第一个数都为1。
//
//然后就简单了，维护三个指针，将三个数组合并为一个严格递增的数组。就是传统的双指针法，只是这题是三个指针。
//
//然后优化一下，不要一下子列出这3个数组，因为并不知道数组预先算出多少合适。
//
//这样就一边移指针，一边算各个数组的下一个数，一边merge，就变成了题解的动态规划法的代码。

//推荐!!!!!!!
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {//注意不是else if,是if
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}

//写法二 推荐！！这样和313统一
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p1]*2, Math.min(dp[p2]*3, dp[p3]*5));
            if (dp[i] == dp[p1]*2) {
                p1++;
            }
            if (dp[i] == dp[p2]*3) p2++;
            if (dp[i] == dp[p3]*5) p3++;
        }

        return dp[n - 1];
    }
}

//官方题解 方法一 复杂度高 笔试时可能超时 不推荐
class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}


