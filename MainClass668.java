/*
 * MainClass668.java
 * Copyright (C) 2022 2022-02-16 10:31 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
/*解题思路

1、m 和 n 的范围在 [1, 30000] 之间，暴力枚举每一个乘积肯定超时。

2、需要换一个思路，因为是要求第k小的数，我们假设它是x，那么在所有的乘积里面，小于等于x的数肯定有大于等于k个。出现大于的情况是因为同一个x可能出现多次。显然，随着x递增，小于等于x的乘积数也是递增的，这就提示我们可以二分查找。

3、二分查找m * n的值域范围，最小为1，最大为m * n，对每一次的中间值mid，统计小于等于mid的乘积个数，如果该个数大于等于k，那么mid就是一个候选答案，并缩小上限继续查找。如果该个数小于k，那么mid肯定不是答案，提高下限继续查找。最后一个满足条件的mid肯定就是答案。

4、如何快速统计小于等于mid的乘积个数？因为横纵向数列都是有序的，所以可以采用双指针的方法，纵向从小到大、横向从大到小，依次找到小于等于x的边界点，这样就可以在O(m+n)的时间内统计到个数。比如下图黄色区域就是小于等于8的乘积个数。
*/
链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/er-fen-cha-zhao-zhi-yu-shuang-zhi-zhen-t-mgo8/
//写法一 推荐
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!isNoGreaterTargetNoLessK(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
    
    boolean isNoGreaterTargetNoLessK(int target, int m, int n, int k) {
        int j = n, count = 0;

        for (int i = 1; i <= m; ++i) {
            while (i * j > target) {
                --j;
            }

            count += j;
            if (count >= k) {
                return true;
            }
        }

        return false;
    }


}

//写法二
/*
class Solution {
public:
    int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n, kthNumber = 0;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (isNoGreaterTargetNoLessK(m, n, k, middle)) {
                kthNumber = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }

        return kthNumber;
    }

    bool isNoGreaterTargetNoLessK(int m, int n, int k, int target) {
        int i, j = n, count = 0;

        for (i = 1; i <= m; ++i) {
            while (i * j > target) {
                --j;
            }

            count += j;
            if (count >= k) {
                return true;
            }
        }

        return false;
    }
};
*/

//写法三
class Solution {
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}

