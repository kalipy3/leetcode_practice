链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
//重点：题意转换。把「最多可以把 K 个 0 变成 1，求仅包含 1 的最长子数组的长度」转换为 「找出一个最长的子数组，该子数组内最多允许有 K 个 0 」。
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0, r = 0;
        int N = nums.length;
        int zeroCnt =0 ;

        while (r < N) {
            if (nums[r] == 0) {
                zeroCnt++;
            }

            while (zeroCnt > k) {
                if (nums[l] == 0)
                    zeroCnt--;

                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
