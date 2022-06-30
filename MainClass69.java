public class Solution {

    public int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }
}

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//kalipy一次过 推荐
class Solution {
    public int mySqrt(int x) {
        long l = 0;
        long r = x;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (x == mid * mid) return (int)mid;
            else if (x < mid * mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return (int)r;
    }
}

