作者：carlsun-2
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/bang-ni-ba-0-1bei-bao-xue-ge-tong-tou-by-px33/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//请耐心的把题解看完
//01背包中，dp[i] 表示： 容量为j的背包，所背的物品价值可以最大为dp[j]。
//套到本题，dp[i]表示 背包总容量是i，最大可以凑成i的子集总和为dp[i]。
public class Solution {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }
        
        // dp[i]中的i表示背包内总和
        // 题目中说：每个数组中的元素不会超过 100，数组的大小不会超过 200
        // 总和不会大于20000，背包最大只需要其中一半，所以10001大小就可以了
        int dp[] = new int[10001];

        int target = sum / 2;

        // 开始 01背包
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) { // 每一个元素一定是不可重复放入，所以从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        // 集合中的元素正好可以凑成总和target
        if (dp[target] == target) return true;
        return false;


    }
}

