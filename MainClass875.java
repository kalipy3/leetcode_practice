//二分查找区间怎么定?
//https://www.bilibili.com/video/BV147411i7zu

//这个有时间再看
//https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/xsshgi/

//先看这个题解
//作者：liweiwei1419
//链接：https://leetcode-cn.com/problems/koko-eating-bananas/solution/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution {

    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                //区间 [mid + 1, right] 的反面区间 [left, mid] ，因此设置右边界 right 为 mid。
                //只要一个区间判断正确了，另一个区间就不用判断了，直接写类似 left = mid + 1; 的写法，我觉得比较让人迷惑，所以我在注释里面都会写下一轮搜索的区间是什么，避免出错。写好以后，反面区间就可以一下子看出来，再设置边界就不会出错了。
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}

