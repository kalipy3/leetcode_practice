作者：fuxuemingzhu
链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
