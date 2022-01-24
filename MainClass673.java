//请先看300题
//然后直接看这个代码
//dp[i]：到nums[i]为止的最长递增子序列长度
//count[i]：到nums[i]为止的最长递增子序列个数
public int findNumberOfLIS(int[] nums) {

    if (nums.length == 0) {
        return 0;
    }

    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];

    Arrays.fill(dp, 1);
    Arrays.fill(count, 1);

    int max = 1, res = 0;

    for (int i = 1; i < dp.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (dp[j] + 1 > dp[i]) { //如果+1长于当前LIS 则组合数不变
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (dp[j] + 1 == dp[i]) { //如果+1等于当前LIS 则说明找到了新组合
                    count[i] += count[j];
                }
            }
        }
        max = Math.max(max, dp[i]);
    }

    for (int i = 0; i < nums.length; i++)
        if (dp[i] == max) res += count[i];

    return res;
}
